<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
//String message = request.getParameter("message");
%>
<jsp:useBean id="msg" class="sample.SimpleData" />
<%-- SimpleData msg = new SimpleData(); 이거대신 sample.SimpleData 사용 --%>
<jsp:setProperty name="msg" property="message" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>간단한 빈즈 프로그램 결과</h1>
	<hr color="red"></hr>
	<br></br>
	<font size="5"> 메세지 : <jsp:getProperty name="msg"
			property="message" /> <%--<%=message%> --%>
	</font>
	<%response.sendRedirect("/jsptest/Login"); %>
</body>
</html>