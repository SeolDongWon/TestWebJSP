package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.VisitListVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbcon.DBcon;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");

		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		StringBuffer sql = new StringBuffer();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		VisitListVO vVO = null;

		try {
			pw.println("<html>");
			pw.println("<head><title>메인</title>");
			pw.println(
					"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
			pw.println(
					"<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js'></script>");
			pw.println("</head>");
			if (session != null) {
				String sessionId = session.getId();
				System.out.println("세션 아이디 : " + sessionId);
				String user = (String) session.getAttribute("user");
				String id = (String) session.getAttribute("id");
				pw.println("<body>");
				pw.println("<table align='center' border='1' width='300'>");
				pw.println("<tr>");
				pw.println("<td width='300' align='center'>" + user + "님 로그인 되었습니다.</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td align='center'>");
				pw.println("<a href='LoginInfo'>회원정보</a>");
				pw.println("<a href='Logout'>로그아웃</a>");
				pw.println("</td>");
				pw.println("</tr>");
				pw.println("</table>");
//				================================================방명록
				pw.println("<form method='post' action='/jsptest/VisitInsert'>");
				pw.println("<table align='center' width='500' border='1'>");
				pw.println("<div class='container-sm'>");
				pw.println("<div class='mb-3'>");
				pw.println("<label for='exampleFormControlInput1' class='form-label'>작성자</label>");
				pw.println("<input type='text' class='form-control' name='writer' readonly value='" + id + "'>");
				pw.println("</div>");
				pw.println("<div class='mb-3'>");
				pw.println("<label for='exampleFormControlTextarea1' class='form-label'>내용</label>");
				pw.println("<textarea class='form-control' name='memo' rows='3'></textarea>");
				pw.println("</div>");
				pw.println("<input type='submit' value='저장'>");
				pw.println("<input type='reset' value='취소'>");
				pw.println("</div>");
				pw.println("</table>");
				pw.println("</form>");

//				================================================방명록
				pw.println("<div class='container mt-3'>");
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
				con = DBcon.getConnection();
				sql.append("select no, writer, memo, regdate from visit order by no desc");
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				while (rs.next()) {
					vVO = new VisitListVO();
					vVO.setNo(rs.getInt("no"));
					vVO.setWriter(rs.getString("writer"));
					vVO.setMemo(rs.getString("memo"));
					vVO.setRegdate(rs.getString("regdate"));
					pw.println("<tr>");
					pw.println("<td>" + vVO.getNo() + "</td>");
					pw.println("<td>" + vVO.getWriter() + "</td>");
					pw.println("<td>" + vVO.getRegdate() + "</td>");
					pw.println("<td>" + vVO.getMemo() + "</td>");
					pw.println("</tr>");
				}
				pw.println("</tbody>");
				pw.println("</table>");
				pw.println("</div>");
//				================================================방명록
				pw.println("</body>");
				pw.println("</html>");
			} else {
				pw.println("<body>");
				pw.println("<form method='post' action='LoginCheck'>");
				pw.println("<table  align='center' border='1' width='300'>");
				pw.println("<tr>");
				pw.println("<th width='100'>아이디</th>");
				pw.println("<td width='200'>&nbsp;<input type='text' name='id'></td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<th width='100'>비번</th>");
				pw.println("<td width='200'>&nbsp;<input type='password' name='pwd'></td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td align='center' colspan='2'>");
				pw.println("<input type='button' value='회원가입'>");
				pw.println("<a href='bbs/memberJoin.html'>회원가입</a>");
				pw.println("<input type='submit' value='로그인'>");
				pw.println("</td>");
				pw.println("</tr>");
				pw.println("</table>");
				pw.println("</form>");
				pw.println("</body>");
				pw.println("</html>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
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
