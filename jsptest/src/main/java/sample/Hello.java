package sample;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebInitParam;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String tel;
	private String password;
	Date date = new Date();
	
	public Hello() {
		super();
	}
	



	@Override
	public void init() throws ServletException {
		super.init();
		ServletConfig sc= this.getServletConfig();
		tel = sc.getInitParameter("tel");
		password = sc.getInitParameter("password");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Hello</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>Hello Web!</h1>");
		pw.println("<hr>");
		pw.println(date.toString());
		pw.println("<hr>");
		pw.println("<li>전화번호:"+this.getTel()+"</li>");
		pw.println("<li>비밀번호:"+password+"</li>");
		pw.println("<a href=\'http://localhost:8080/jsptest/request_info.html\' class=\'btn btn-success\'>request_info</a>");
		pw.println("</html></body>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}


