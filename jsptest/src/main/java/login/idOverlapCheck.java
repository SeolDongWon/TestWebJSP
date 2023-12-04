package login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class idOverlapCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public idOverlapCheck() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		StringBuffer sql = new StringBuffer();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;

		String inputId = request.getParameter("inputId");
		request.setAttribute("id", inputId);

		con = dBcon.DBcon.getConnection();
		sql.append("select * from login where id=?");

		try {
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, inputId);
			rs = ps.executeQuery();
			System.out.println(inputId);
			System.out.println(ps.executeUpdate());
			if (0 != ps.executeUpdate()) {
				flag = true;
				System.out.println("if1");
			}
			if (flag) {
				System.out.println("if2-1");
				request.setAttribute("check", "사용불가");
				RequestDispatcher rd = request.getRequestDispatcher("idOverlapInput");
				rd.forward(request, response);

			} else {
				System.out.println("if2-2");
				request.setAttribute("check", "사용가능");
				RequestDispatcher rd = request.getRequestDispatcher("idOverlapInput");
				rd.forward(request, response);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
				if (rs != null) {
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
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
