package bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBcon.DBcon;

public class DeleteList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteList() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("DeleteList");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		
		StringBuffer sql = new StringBuffer();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String writer = null;
		String no = null;
		System.out.println("DeleteList");
		writer = (String) session.getAttribute("id");
		no = request.getParameter("no");
		System.out.println(writer);
		System.out.println(no);
		
//		sql.append(
//				"delete from visit where writer = ? and no = ?");
//		// 데이터베이스연결
//		try {
//			System.out.println("DeleteList");
//			con = DBcon.getConnection();
//			ps = con.prepareStatement(sql.toString());
//			ps.setString(1, writer);
//			ps.setInt(2, Integer.parseInt(no));
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		finally {
//			if (ps != null) {
//				try {
//					ps.close();
//					if (con != null) {
//						con.close();
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		// 보여줄 화면설계된 페이지 요청
		response.sendRedirect("LoginInfo");
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
