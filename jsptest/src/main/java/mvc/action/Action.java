package mvc.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.control.ActionForward;

public interface Action {
	//추상메소드
	public abstract ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
		
}
