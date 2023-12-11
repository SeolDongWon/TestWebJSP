package mvcMem.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcMem.control.ActionForward;
import mvcMem.model.StudentDAO;

public class DeleteProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StudentDAO dao = StudentDAO.getInstance();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("loginID");
		String pass = request.getParameter("pass");
		int check = dao.deleteMember(id, pass);
		if (check == 1) {
			session.invalidate();
		}
		request.setAttribute("check", check);
		return new ActionForward("/mvcMem/deleteProc.jsp",false);
	}

}
