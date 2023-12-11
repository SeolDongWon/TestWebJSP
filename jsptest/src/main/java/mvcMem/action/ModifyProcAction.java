package mvcMem.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcMem.control.ActionForward;
import mvcMem.model.StudentDAO;
import mvcMem.model.StudentVO;

public class ModifyProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StudentDAO dao = StudentDAO.getInstance();
		StudentVO vo = new StudentVO();
		HttpSession session = request.getSession();
		vo.setId((String)session.getAttribute("loginID"));
		vo.setPass(request.getParameter("pass"));
		vo.setName(request.getParameter("name"));
		vo.setPhone1(request.getParameter("phone1"));
		vo.setPhone2(request.getParameter("phone2"));
		vo.setPhone3(request.getParameter("phone3"));
		vo.setEmail(request.getParameter("email"));
		vo.setZipcode(request.getParameter("zipcode"));
		vo.setAddress1(request.getParameter("address1"));
		vo.setAddress2(request.getParameter("address2"));
		dao.updateMember(vo);
		return new ActionForward("/mvcMem/modifyProc.jsp",false);
	}

}
