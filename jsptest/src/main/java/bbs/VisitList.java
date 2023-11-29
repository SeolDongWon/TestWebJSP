package bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import controller.DBcon;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import model.VisitVO;

public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		StringBuffer sql = new StringBuffer();
//		VisitVO vVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql.append("select no, writer, memo, regdate from visit order by no desc");

		try {
//			con = DBcon.getConnection();

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(sql.toString());
			pw.println("<html>");
			pw.println("<head><title>방명록4</title>");
			pw.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
			pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js'></script>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class='container mt-3'>");
//			pw.println("<h2>Striped Rows</h2>");
//			pw.println("<p>The .table-striped class adds zebra-stripes to a table:</p> ");
//			pw.println("<table align=center width=500 border=1>");
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
//				vVO = new VisitVO();
//				vVO.setNo(rs.getInt("no"));
//				vVO.setWriter(rs.getString("writer"));
//				vVO.setMemo(rs.getString("memo"));
//				vVO.setRegdate(rs.getString("regdate"));

				int no = rs.getInt("no");
				String writer = rs.getString("writer");
				String memo = rs.getString("memo");
				java.sql.Date regdate = rs.getDate("regdate");
				pw.println("<tr>");
//				pw.println("<th width=50>번호</th>");
//				pw.println("<td width=50 align=center>" + no + "</td>");
				pw.println("<td>" + no + "</td>");
//				pw.println("<th width=70>작성자</th>");
//				pw.println("<td width=180 align=center>" + writer + "</td>");
				pw.println("<td>" + writer + "</td>");
//				pw.println("<td width=50 align=center>날짜</td>");
//				pw.println("<td width=100 align=center>" + regdate + "</td>");
				pw.println("<td>" + regdate + "</td>");
//				pw.println("</tr>");
//				pw.println("<tr>");
//				pw.println("<th width=50>내용</th>");
//				pw.println("<td colspan=5>&nbsp;<textarea row=3 cols=50>" + memo + "</textarea></td>");
				pw.println("<td>" + memo + "</td>");
				pw.println("</tr>");

			}
			pw.println("</tbody>");
			pw.println("</table>");
//			pw.println("<p>");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
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
