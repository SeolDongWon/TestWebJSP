<%@page import="projectS1.S1MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GetMemberList</title>
</head>
<body>
	<table>
		<tr>
			<td><strong>ID</strong></td>
			<td><strong>PASSWD</strong></td>
			<td><strong>NAME</strong></td>
			<td><strong>BIRTHDAY</strong></td>
			<td><strong>TEL</strong></td>
			<td><strong>POSTCODE</strong></td>
			<td><strong>ADDRESS</strong></td>
		</tr>
		<jsp:useBean id="sMDAB" class="projectS1.S1MemberDAO"></jsp:useBean>
		<%
		ArrayList<S1MemberVO> sMVList = sMDAB.getMemberList();
		for (int i = 0; i < sMVList.size(); i++) {
			S1MemberVO vo = sMVList.get(i);
		%>
		<tr>
			<td><%=vo.getId()%></td>
			<td><%=vo.getPassword()%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getBirthday()%></td>
			<td><%=vo.getTel()%></td>
			<td><%=vo.getPostcode()%></td>
			<td><%=vo.getAddress()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="/jsptest/projectS1/JoinMain.jsp">JoinMain</a>
</body>
<style>
table, td {
	border-collapse: collapse;
	border: 1px solid black;
	padding: 5px 10px 5px 10px;
}
</style>
</html>