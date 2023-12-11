package mvcMem.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcMem.control.ActionForward;
import mvcMem.model.StudentDAO;
import mvcMem.model.StudentVO;

public class RegProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StudentDAO dao = StudentDAO.getInstance();
		StudentVO vo = new StudentVO();
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass"));
		vo.setName(request.getParameter("name"));
		vo.setPhone1(request.getParameter("phone1"));
		vo.setPhone2(request.getParameter("phone2"));
		vo.setPhone3(request.getParameter("phone3"));
		vo.setEmail(request.getParameter("email"));
		vo.setZipcode(request.getParameter("zipcode"));
		vo.setAddress1(request.getParameter("address1"));
		vo.setAddress2(request.getParameter("address2"));
		boolean flag = dao.memberInsert(vo);
		request.setAttribute("flag", flag);
		return new ActionForward("/mvcMem/regProc.jsp",false);
	}

}
