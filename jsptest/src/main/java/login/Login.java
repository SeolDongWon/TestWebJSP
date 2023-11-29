package login;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(false);
		try {
			if (session != null) {
				String sessionId = session.getId();
				System.out.println("세션 아이디 : " + sessionId);
				String user = (String) session.getAttribute("user");
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<table border='1' width='300'>");
				pw.println("<tr>");
				pw.println("<td width='300' align='center'>" + user + "님 로그인 되었습니다.</td>");
				pw.println("</tr>");
				pw.println("<tr>");
				pw.println("<td align='center'>");
				pw.println("<a href='#'>회원정보</a>");
				pw.println("<a href='Logout'>로그아웃</a>");
				pw.println("</td>");
				pw.println("</tr>");
				pw.println("</table>");
				pw.println("</body>");
				pw.println("</html>");
			} else {
				pw.println("<html>");
				pw.println("<body>");
				pw.println("<form method='post' action='LoginCheck'>");
				pw.println("<table border='1' width='300'>");
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
				pw.println("<input type='submit' value='로그인'>");
				pw.println("</td>");
				pw.println("</tr>");
				pw.println("</form>");
				pw.println("</table>");
				pw.println("</body>");
				pw.println("</html>");
			}
		} finally {
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
