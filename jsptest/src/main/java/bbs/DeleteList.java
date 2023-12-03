package bbs;

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

public class DeleteList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteList() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("start DeleteList");
		HttpSession session = request.getSession();

		StringBuffer sql = new StringBuffer();
		Connection con = null;
		PreparedStatement ps = null;

		String writer = null;
		String[] values = null;
		sql.append("delete from visit where writer = ? and no = ?");
		con = DBcon.getConnection();

		writer = (String) session.getAttribute("id");
		values = request.getParameterValues("writeNo");

		System.out.println(writer);
		if (values != null) {
			try {
				ps = con.prepareStatement(sql.toString());
				for (int i = 0; i < values.length; i++) {
					System.out.println(values[i]);
					ps.setString(1, writer);
					ps.setInt(2, Integer.parseInt(values[i]));
					ps.executeUpdate();
				}
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
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		response.sendRedirect("LoginInfo");
	}


	// 데이터베이스연결

	// 보여줄 화면설계된 페이지 요청

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
