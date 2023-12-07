<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name="";
    String no="";
	  Cookie cookie = new Cookie("name", URLEncoder.encode("홍길동", "UTF-8"));
    Cookie[] cookies = request.getCookies();
    /* cookies[0].setAttribute("no", "100"); */
    if(cookies !=null && cookies.length>0){
    	for(int i=0;i<cookies.length;i++){
    		String cookieName= cookies[i].getName();
    		out.println(cookieName);%><br><%
    		if(cookies[i].getName().equals("name")){
    			name=URLDecoder.decode(cookies[i].getValue(), "UTF-8");
    			no=cookies[i].getAttribute("no");
    		}
    	}
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name=<%=name %><br>
no=<%=no %>
</body>
</html>