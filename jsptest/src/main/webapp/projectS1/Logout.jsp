<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
session = request.getSession(false);
if (session != null) {
	session.invalidate();
}
response.sendRedirect("/jsptest/projectS1/JoinMain.jsp");
%>