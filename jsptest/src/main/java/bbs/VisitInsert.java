package bbs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBcon.DBcon;

public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String writer;
	private String memo;

	public VisitInsert() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuffer query = new StringBuffer();
		
		// 값을 가져온다. 패턴검색
		writer = request.getParameter("writer");
		memo = request.getParameter("memo");
		System.out.println("writer =" + writer);
		System.out.println("memo =" + memo);

		// 데이터베이스 저장 insert
		query.append("insert into visit(no, writer, memo, regdate) values(visit_seq.nextval,?,?,to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'))");
		// 데이터베이스연결
		
		try {
			con = DBcon.getConnection();
			ps = con.prepareStatement(query.toString());
			ps.setString(1, writer);
			ps.setString(2, memo);
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
		// 보여줄 화면설계된 페이지 요청
		response.sendRedirect("VisitList");

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
