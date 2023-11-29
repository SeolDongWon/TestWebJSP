package login;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String dbID;
	private String dbPWD;

	public LoginCheck() {
		super();
	}
	
	

	@Override
	public void init() throws ServletException {
		super.init();
		ServletConfig sc= this.getServletConfig();
		dbID = sc.getInitParameter("dbID");
		dbPWD = sc.getInitParameter("dbPWD");
	}



	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8"); // 한글처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
//		 db에서 사용자 정보 조회... 이 부분의 코딩을 수정해서 만들어볼 것
//		 db에서 조회한 사용자으 ㅣ아이디 비번이 일치하는 경우
//		 클라이언트의 정보를 HttpSesstion객체에 유지시킨다.
//		-----------------------------------------------------------
//		String dbID = "admin"; // config에 넣기
//		String dbPWD = "1234"; // config에 넣기
		if (dbID.equals(id) && dbPWD.equals(pwd)) {
			// HttpSession객체 얻기
			HttpSession session = request.getSession();
			// 클라이언트으 ㅣ정보를 HttpSession객체에 저장
			session.setAttribute("User", id);
		}
//		-----------------------------------------------------------
//		StringBuffer query = new StringBuffer();
//		query.append("select * from login where id=? and pass=?");
//		// 데이터베이스연결
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		String dbID = null; 
//		String dbPWD = null;
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//			ps = con.prepareStatement(query.toString());
//			ps.setString(1, id);
//			ps.setString(2, pwd);
//			System.out.println(ps.executeUpdate());
//			System.out.println("1");
//			if(rs.next()) {
//				System.out.println("2");
//				// HttpSession객체 얻기
//				HttpSession session = request.getSession();
//				// 클라이언트으 ㅣ정보를 HttpSession객체에 저장
//				session.setAttribute("User", id);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

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
