package mvc.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.action.Action;

import java.io.IOException;
import java.io.PrintWriter;

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		if (cmd != null) {
			ActionFactory factory = ActionFactory.getInstance();
			Action action = factory.getAction(cmd);
			ActionForward af = action.execute(request, response);
			if (af.isRedirect() == true) {// redirect
				response.sendRedirect(af.getUrl());
			} else {// forward
				RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
				rd.forward(request, response);
			}

		} else {
			// 페이지요청이 없는 잘못된 명령어 들어오는 것이다. 잘못된 메세지 출력한다.
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head><title>Error</title></head>");
			out.println("<body>");
			out.println("<h4>올바른 요청이 아닙니다!</h4>");
			out.println("<h4>http://localhost:8080/mvc/test.do?cmd=요청키워드</h4>");
			out.println("</body>");
			out.println("</html>");
		}

	}

}
