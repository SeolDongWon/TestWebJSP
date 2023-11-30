package login;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//import model.VisitListVO;

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

		StringBuffer sql = new StringBuffer();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		VisitListVO vVO = null;
		HttpSession session = request.getSession();
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd"); 
		String id = (String) session.getAttribute("id");
		String pwd = null;
		String name = null;
		String birth = null;

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
			pw.println("</table>");
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
