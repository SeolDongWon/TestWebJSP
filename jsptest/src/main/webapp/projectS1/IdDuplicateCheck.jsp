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
	let idCheck =
<%=idCheck%>
	;
	console.log(idCheck);
	if (!idCheck) {
		alert('id사용가능');
	} else {
		let nono = "id중복 사용 불가 ";
		let i = 0
		while (i < 30) {
			nono += "id중복 사용 불가 ";
			i++;
		}
		alert(nono);
	}
	console.log(opener.document.getElementById("id").value);
	opener.document.getElementById("id").value="sssssss";
	window.close();
</script>
<!-- </html> -->