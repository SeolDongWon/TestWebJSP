<%@page import="java.util.Enumeration"%>
<%@page import="projectS1.S1MemberVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JoinMain</title>
</head>
<body>
	<%
	if (session.getAttribute("name") != null) {
		String sessionId = session.getId();
		System.out.println("세션 아이디 : " + sessionId);
		String name = (String) session.getAttribute("name");

	%>
	<table border='1' width='300'>
		<tr>
			<td width='300' align='center'><%=name%>님 로그인 되었습니다.</td>
		</tr>
		<tr>
			<td align='center'><a href='/jsptest/projectS1/UpdateMemberInfoForm.jsp'>회원정보</a>
			<a href='/jsptest/projectS1/deleteMemberForm.jsp'>탈퇴하기</a>
				<a href='/jsptest/projectS1/Logout.jsp'>로그아웃</a></td>
		</tr>
	</table>
	<%
	} else {
	%>
	<form method='post' action='/jsptest/projectS1/LoginCheck.jsp'>
		<table>
			<tr>
				<th>id</th>
				<td><input type='text' name='id'></td>
			</tr>
			<tr>
				<th>password</th>
				<td><input type='password' name='password'></td>
			</tr>
			<tr>
				<td><a href="/jsptest/projectS1/GetMemberList.jsp">MemberList</a></td>
				<td><a href="/jsptest/projectS1/JoinForm.jsp">회원가입</a> <input
					type='submit' value='로그인'></td>
			</tr>
		</table>
	</form>
	<%
	}
	%>
</body>
<style>
table {
	margin: auto;
}

table, td, th, input {
	border-collapse: collapse;
	border: 1px solid black;
	padding: 5px 10px 5px 10px;
	/* padding: 2px; */
}
</style>
</html>