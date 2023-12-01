<%@page import="member.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="person" class="member.PersonVO" />
<%-- SimpleData msg = new SimpleData(); 이거대신 sample.SimpleData 사용 --%>
<jsp:setProperty name="person" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>간단한 빈즈 프로그램 결과</h1>
	<jsp:getProperty name="person" property="id" />
	<jsp:getProperty name="person" property="name" />
	<jsp:getProperty name="person" property="email" />
</html>