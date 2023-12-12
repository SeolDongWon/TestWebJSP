package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import board.action.CommandAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 명령어와 명령어 처리 클래스를 쌍으로 지정
	private Map<String, Object> commandMap = new HashMap<String, Object>();
	private String propsP;
	// 명령어와 처리클래스가 매핑되어 있는 properties 파일을 읽어서
	// Map 객체인 commandMap에 저장
	// 명령어와 처리클래스가 매핑되어 있는 properties 파일은
	// Command.properties파일
	// @SuppressWarnings("unchecked")미확인오퍼레이션과 관련도니 경고를 억제
	@SuppressWarnings("unchecked")
	public void inint(ServletConfig config) {
		// web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
		String props = config.getInitParameter("boardPropertyConfig");
		propsP = props;
		// 명령어와 처리클래스의 매핑정보를 저장할 properties객체 생성
		Properties pr = new Properties();
		FileInputStream f = null;
		String path = config.getServletContext().getRealPath("/WEB-INF");

		try {
			// Command.properties파일의 내용을 읽어옴
			f = new FileInputStream(new File(path, props));
			// Command.properties 파일의 정보를 Properties객체에 저장
			pr.load(f);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (f != null)
					f.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Iterator객체는 Enumeration객체를 확장시킨 개념의 객체
			Iterator<Object> keyIter = pr.keySet().iterator();
			System.out.println("keyIter : "+keyIter.toString());
			// 객체를 하나씩 꺼내서 그 객체명으로 Properties객체에 저장된 객체에 접근
			while (keyIter.hasNext()) {
				String command = (String) keyIter.next();
				System.out.println("keyIter command :"+command);
				String className = pr.getProperty(command);
				System.out.println("getProperty className : "+ className);

				try {
					Class commandClass = Class.forName(className);
					Object commandInstance = commandClass.newInstance();// 해당클래스의 객체를 생성
					// Map객체인 commandMap에 객체저장
					commandMap.put(command, commandInstance);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	// 사용자의 요청을 분석해서 해당 작업을 처리
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("propsP : "+propsP);
		
		
		String view = null;
		CommandAction com = null;

		String command = request.getRequestURI();
		System.out.println("command : "+command);
		System.out.println("commandMap : "+commandMap.toString());
		System.out.println("request.getContextPath() : "+request.getContextPath().toString());
		if (command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
		com = (CommandAction) commandMap.get(command);
		System.out.println("com : "+com.toString());
		try {
			view = com.requestPro(request, response);
			System.out.println("view : "+view);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		System.out.println("dispatcher : "+dispatcher.toString());
		dispatcher.forward(request, response);

	}

}
