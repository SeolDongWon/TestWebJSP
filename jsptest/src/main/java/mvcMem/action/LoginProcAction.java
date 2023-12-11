package mvcMem.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import mvcMem.control.ActionForward;
import mvcMem.model.StudentDAO;

public class LoginProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StudentDAO dao = StudentDAO.getInstance();
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		int check = dao.loginCheck(id, pass);
		if (check == 1) {// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginID", id);
		} else if (id != null && pass != null) {
			request.setAttribute("check", check);
		}
		return new ActionForward("mvcMem.mdo?cmd=login", false);
	}
}
