package login;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import DBcon.DBcon;

public class memberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String inputId;
	private String inputPw;
	private String inputName;
	private String inputBirth;
	
    public memberJoin() {
        super();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println("process");
    	inputId = request.getParameter("inputId");
    	inputPw = request.getParameter("inputPw");
    	inputName = request.getParameter("inputName");
    	inputBirth = request.getParameter("inputBirth");
		System.out.println("writer ="+inputId);
		System.out.println("memo ="+inputPw);

		// 데이터베이스 저장 insert
		StringBuffer query = new StringBuffer();
		query.append("insert into LOGIN(ID, PASS, name, birth) values(?,?,?,?)");
		// 데이터베이스연결
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBcon.getConnection();
			ps = con.prepareStatement(query.toString());
			ps.setString(1, inputId);
			ps.setString(2, inputPw);
			ps.setString(3, inputName);
			ps.setString(4, inputBirth);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		finally {
			if (ps != null) {
				try {
					ps.close();
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//보여줄 화면설계된 페이지 요청
		response.sendRedirect("Login");
    	
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		processRequest(request,response);
	}

}
