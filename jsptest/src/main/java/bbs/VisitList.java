package bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DBcon.DBcon;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VisitListVO;

public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		StringBuffer sql = new StringBuffer();
		VisitListVO vVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBcon.getConnection();
		sql.append("select no, writer, memo, regdate from visit order by no desc");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pw.println("<html>");
			pw.println("<head><title>방명록4</title>");
			pw.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
			pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js'></script>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class='container mt-3'>");
			pw.println("<table class=\"table table-striped\">");
			pw.println("<thead>");
			pw.println("<tr>");
			pw.println("<th>번호</th>");
			pw.println("<th>작성자</th>");
			pw.println("<th>날짜</th>");
			pw.println("<th>내용</th>");
			pw.println("</tr>");
			pw.println("</thead>");
			pw.println("<tbody>");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vVO = new VisitListVO();
				vVO.setNo(rs.getInt("no"));
				vVO.setWriter(rs.getString("writer"));
				vVO.setMemo(rs.getString("memo"));
				vVO.setRegdate(rs.getDate("regdate"));

				pw.println("<tr>");
				pw.println("<td>" + vVO.getNo() + "</td>");
				pw.println("<td>" + vVO.getWriter() + "</td>");
				pw.println("<td>" + vVO.getRegdate() + "</td>");
				pw.println("<td>" + vVO.getMemo() + "</td>");
				pw.println("</tr>");

			}
			pw.println("</tbody>");
			pw.println("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		pw.println("<p align=center><a href=bbs/write.html class='btn btn-success'>글쓰기</a></p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

	public VisitList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
