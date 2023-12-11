package mvcMem.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import mvcMem.control.ActionForward;
import mvcMem.model.StudentDAO;

public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("IdCheckAction");
		StudentDAO dao = StudentDAO.getInstance();
		String id = request.getParameter("id");
		boolean check = dao.idCheck(id);
		System.out.println(id);
		System.out.println(check);
		
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		
		return new ActionForward("/mvcMem/idCheck.jsp",false);
	}

}
