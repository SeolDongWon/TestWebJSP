package login;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//import model.VisitListVO;
import model.VisitListVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBcon.DBcon;

public class LoginInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginInfo() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();

		StringBuffer sql = new StringBuffer();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		VisitListVO vVO = null;
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd"); 
		String id = (String) session.getAttribute("id");
		String pwd = null;
		String name = null;
		String birth = null;
		String writeCnt = null;

		try {
			con = DBcon.getConnection();
			sql.append("select * from login where id=?");
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
//				vVO = new VisitListVO();
				pwd = rs.getString("pass");
				name = rs.getString("name");
				birth = rs.getString("birth");
				writeCnt = Integer.toString(rs.getInt("writeCnt"));
			}

			pw.println("<html>");
			pw.println("<head><title>메인</title>");
			pw.println(
					"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
			pw.println(
					"<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js'></script>");
			pw.println("</head>");
//			String sessionId = session.getId();
//			System.out.println("세션 아이디 : " + sessionId);
//			String user = (String) session.getAttribute("user");
			pw.println("<body>");
			pw.println("<table align='center' border='1' width='300'>");
			pw.println("<tr>");
			pw.println("<td> 아이디 </td>");
			pw.println("<td>" + id + "</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td> 비밀번호 </td>");
			pw.println("<td>" + pwd + "</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td> 이름 </td>");
			pw.println("<td>" + name + "</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td> 생일 </td>");
			pw.println("<td>" + birth + "</td>");
			pw.println("</tr>");
			pw.println("<td> 작성글 수 </td>");
			pw.println("<td>" + writeCnt + "</td>");
			pw.println("</tr>");
			pw.println("</table>");
//			================================================방명록
			pw.println("<div class='container mt-3'>");
			pw.println("<table class=\"table table-striped\">");
			pw.println("<thead>");
			pw.println("<tr>");
			pw.println("<th>삭제체크</th>");
			pw.println("<th>번호</th>");
			pw.println("<th>작성자</th>");
			pw.println("<th>날짜</th>");
			pw.println("<th>내용</th>");
			pw.println("</tr>");
			pw.println("</thead>");
			pw.println("<tbody>");
			ps.close();
			rs.close();
			VisitListVO vVO = null;
//			con = DBcon.getConnection();
//			sql = null;
			sql.delete(0, sql.length());
			sql.append("select no, writer, memo, regdate from visit where writer = ? order by no desc");
//			ps = null;
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, id);
//			rs = null;
			rs = ps.executeQuery();
			pw.println("<form method='post' action='DeleteList'>");
			pw.println("<input type='submit' value='삭제'>");
			while (rs.next()) {
				vVO = new VisitListVO();
				vVO.setNo(rs.getInt("no"));
				vVO.setWriter(rs.getString("writer"));
				vVO.setMemo(rs.getString("memo"));
				vVO.setRegdate(rs.getString("regdate"));
				
				pw.println("<tr>");
				pw.println("<td><input type='checkbox' name='writeNo' value='"+vVO.getNo()+"'></td>");
//				pw.println("<td><input type='checkbox' name='writeNo' value='333'></td>");
				pw.println("<td>" + vVO.getNo() + "</td>");
				pw.println("<td>" + vVO.getWriter() + "</td>");
				pw.println("<td>" + vVO.getRegdate() + "</td>");
				pw.println("<td>" + vVO.getMemo() + "</td>");
				pw.println("<td>");
				
				pw.println("<td>");
				pw.println("</tr>");
			}
			pw.println("</form>");
			pw.println("</tbody>");
			pw.println("</table>");
			pw.println("</div>");
//			pw.println("<p align=center><a href=bbs/write.html class='btn btn-success'>글쓰기</a></p>");
//			================================================방명록
			
			
			
			pw.println("</body>");
			pw.println("</html>");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
				if (rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pw.close();
		}
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
