package mvc.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.control.ActionForward;

public class indexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//curd를 진행한다. : 로직(여러분 팀에서 정한다); 이 클래스는 indexAction이니 검색기능을 진행한다.
		
		System.out.println("indexAction execute");
		return new ActionForward("index.jsp",false);
	}
}
