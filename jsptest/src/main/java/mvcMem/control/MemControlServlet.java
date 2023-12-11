package mvcMem.control;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcMem.action.*;

public class MemControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cmd = request.getParameter("cmd");
		
		System.out.println("MemControlServlet");
		System.out.println(cmd);
		
		if(cmd!=null) {
			ActionFactory factory = ActionFactory.getInstance();
			Action action = factory.getAction(cmd);
			ActionForward af = action.execute(request, response);
			if(af.isRedirect()) {
				response.sendRedirect(af.getUrl());
			}else {
				request.getRequestDispatcher(af.getUrl()).forward(request, response);
			}
		}else {
			PrintWriter out = response.getWriter();
			out.println("<h1>올바른 요청이 아닙니다.</h4>");
		}
	}

}
