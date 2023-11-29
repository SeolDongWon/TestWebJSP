package sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class MyfirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyfirstServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// 화면문자셋
		response.setContentType("text/html;charset=utf-8");
		// 화면 출력할 객체 생성
		PrintWriter pw = response.getWriter();
		//출력할 데이터
		//출력할 내용 설정
		Date date = new Date();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>My First Servlet Program</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h2>My First Servlet Program!</h2>");
		pw.println("<hr>");
		pw.println(date.toString());
		pw.println("<br>");
		pw.println("<a href=\'http://localhost:8080/jsptest/request_info.html\' class=\'btn btn-success\'>request_info</a>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
