package sample;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Source extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Source() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Destination</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1> Source입니다</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally { 
//            out.close();
//        }
		System.out.println("start point");
		// 1. 값을 가져와서,->디비(crud)
//		request.setAttribute("name", "seoldongwon");
//		request.setAttribute("age", 33);
		// 2. 화면에 뿌려줄 서블릿 콜한다. 
		// forward 방식으로 값을 전달
//		RequestDispatcher rd= request.getRequestDispatcher("Destination");
//		rd.forward(request, response);
		// redirect 방식으로 값을 전달
		String age = request.getParameter("age");
		HttpSession session = request.getSession();
		session.setAttribute("name", "Seol.D.W");
		session.setAttribute("age", age);
		response.sendRedirect("Destination");
//		response.sendRedirect("Destination?age2=30");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
