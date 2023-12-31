package mvc;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String propsP;
	// 명령어와 명령어 처리 클래스를 쌍으로 저장
	private Map<String, Object> commandMap = new HashMap<String, Object>();

	// 명령어와 처리클래스가 매핑되어 있는 properties 파일을
	// 읽어서 Map객체인 commandMap에 저장
	// 명령어와 처리클래스가 매핑되어 있는 properties 파일은
	// Command.properties파일
	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
		// web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");
		propsP =props;
		// 명령어와 처리클래스의 매핑정보를 저장할 Properties객체 생성
		Properties pr = new Properties();
		String path = config.getServletContext().getRealPath("/WEB-INF");
		FileInputStream f = null;
		try {
			// Command.properties파일의 내용을 읽어옴
			f = new FileInputStream(new File(path, props));
			// Command.properties파일의 정보를 Properties객체에 저장
			pr.load(f);
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ex) {
				}
		}
		// Iterator객체는 Enumeration객체를 확장시킨 개념의 객체
		Iterator<Object> keyIter = pr.keySet().iterator();
		// 객체를 하나씩 꺼내서 그 객체명으로 Properties객체에 저장된 객체에 접근
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			System.out.println("keyIter command :"+command);
			String className = pr.getProperty(command);
			System.out.println("getProperty className : "+ className);
			System.out.println(className);
			try {// 해당 문자열을 클래스로 만든다.
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();// 해당클래스의 객체를 생성
				// Map객체인 commandMap에 객체 저장
				commandMap.put(command, commandInstance);
				System.out.println("commandMap.toString()");
				System.out.println(commandMap.toString());
			} catch (ClassNotFoundException e) {
				throw new ServletException(e);
			} catch (InstantiationException e) {
				throw new ServletException(e);
			} catch (IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}

	public void doGet(// get방식의 서비스 메소드
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(// post방식의 서비스 메소드
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	// 시용자의 요청을 분석해서 해당 작업을 처리
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("propsP : "+propsP);
		String view = null;
		CommandProcess com = null;
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getContextPath());
		try {
			String command = request.getRequestURI(); // /jsptest/mvc/message.di
			if (command.indexOf(request.getContextPath()) == 0) { // /jsptest
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandProcess) commandMap.get(command);
			view = com.requestPro(request, response);
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
