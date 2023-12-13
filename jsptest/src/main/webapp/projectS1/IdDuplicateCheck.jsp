<%@page import="projectS1.S1MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
S1MemberDAO sMDA = new S1MemberDAO();
boolean idCheck = sMDA.idDuplicateCheck(id);
%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IdDuplicateCheck</title>
</head>

<body> -->
<!-- </body> -->
<script>
	if (<%=idCheck%>) {
  opener.document.getElementById('idError').innerHTML="id중복 사용 불가 "
	}
	window.close();
</script>
<!-- </html> -->