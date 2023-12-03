package login;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbcon.DBcon;

import java.sql.ResultSet;

public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String dbID; // ServletConfig item
	private String dbPWD; // ServletConfig item

	public LoginCheck() {
		super();
	}

	@Override // ServletConfig item method
	public void init() throws ServletException {
		super.init();
		ServletConfig sc= this.getServletConfig();
		dbID = sc.getInitParameter("dbID");
		dbPWD = sc.getInitParameter("dbPWD");
		System.out.println(sc);
		System.out.println(dbID);
		System.out.println(dbPWD);
		System.out.println("LoginCheck.init()");
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8"); // 한글처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
//		 db에서 사용자 정보 조회... 이 부분의 코딩을 수정해서 만들어볼 것
//		 db에서 조회한 사용자으 ㅣ아이디 비번이 일치하는 경우
//		 클라이언트의 정보를 HttpSesstion객체에 유지시킨다.
//		-----------------------------------------------------------
		if (dbID.equals(id) && dbPWD.equals(pwd)) {
//			 HttpSession객체 얻기
			HttpSession session = request.getSession();
//			 클라이언트으 ㅣ정보를 HttpSession객체에 저장
			session.setAttribute("user", id);
			response.sendRedirect("Login");
			return;
		}
//		-----------------------------------------------------------
		StringBuffer sql = new StringBuffer();
		sql.append("select * from login where id=? and pass=?");
//		// 데이터베이스연결
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBcon.getConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				HttpSession session = request.getSession();
				String name = rs.getString("name");
//				 클라이언트으 ㅣ정보를 HttpSession객체에 저장
				session.setAttribute("user", name);
				session.setAttribute("id", id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (con != null) {
					con.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect("Login");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
