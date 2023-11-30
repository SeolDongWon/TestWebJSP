package sample;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Destination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Destination() {
        super();
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
//=================================================forward로 값을 받을 때 사용
//    	String name = (String)request.getAttribute("name");
//    	String age = request.getParameter("age");
//=================================================forward로 값을 받을 때 사용
    	HttpSession session = request.getSession(false);
    	String name = (String)session.getAttribute("name");
    	String age = (String)session.getAttribute("age");
    	String age2 = (String)request.getParameter("age2");
    	String sessionID = session.getId();
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Destination</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Destination Servlet 입니다</h1>");
            out.println("<h1>"+sessionID+"</h1>");
            out.println("<h1>"+name+"</h1>");
            out.println("<h1>"+age+"</h1>");
            out.println("<h1>"+age2+"</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
}
