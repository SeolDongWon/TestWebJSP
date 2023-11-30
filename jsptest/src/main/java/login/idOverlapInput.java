package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class idOverlapInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public idOverlapInput() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");

		PrintWriter pw = response.getWriter();

		String id = (String) request.getAttribute("id");
		String check = (String) request.getAttribute("check");

		if (id==null) {
			id = request.getParameter("id");
			check = request.getParameter("check");
		}

		System.out.println(id);
		System.out.println(check);

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Hello</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>Hello Web!</h1>");
		pw.println("<h1>idOverlapCheck.jsp</h1>");
		pw.println("<form action='/jsptest/idOverlapCheck' name='form1' method='get'>");
		pw.println("<input type='text' value='" + id + "' name='inputId' id='inputId'>");
		pw.println("<input type='submit' name='button' id='submit' value='중복체크'>");
		pw.println("<h1>" + check + "</h1>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
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
