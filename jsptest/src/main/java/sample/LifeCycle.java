package sample;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycle() {
        super();
        System.out.println("LifeCycle");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	public void destroy() {
		System.out.println("destroy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		Date date = new Date();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>LifeCycle</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<table>");
		pw.println("<ul>");
		for (int i=0;i<5;i++) {
			pw.println("<li>");
			pw.println(date.toString());
			pw.println("</li>");
		}
		pw.println("</ul>");
		pw.println("</table>");
		pw.println("<hr>");
		pw.println("<a href=\'http://localhost:8080/jsptest/request_info.html\' class=\'btn btn-success\'>request_info</a>");
		pw.println("</html></body>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

}
