<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="projectS1.S1MemberDAO"%>
<%@page import="projectS1.S1MemberVO"%>
<%
S1MemberDAO s1MDA = new S1MemberDAO();
String id = (String) session.getAttribute("id");
String pass = request.getParameter("password");
System.out.println(pass);

int result = s1MDA.deleteMember(id, pass);
if (result == 1) {
	session.invalidate();
%>
<html>
<body>
	<script>
		alert("탈퇴성공");
	</script>
	<%
	response.sendRedirect("JoinMain.jsp");
	} else {
	%>
	<script>
		alert("탈퇴실패");
		history.go(-1);
	</script>
	<%
	}
	%>
</body>
</html>
