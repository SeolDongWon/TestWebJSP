<%@page import="projectS1.S1MemberVO"%>
<%@page import="projectS1.S1MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="sMVB" class="projectS1.S1MemberVO" />
<jsp:setProperty name="sMVB" property="*" />
<%
S1MemberDAO s1MDA = new S1MemberDAO();
S1MemberVO s1MV = s1MDA.LoginCheck(sMVB);
if (s1MV != null) {
	/* session.setAttribute("s1MV", s1MV); */
	session.setAttribute("id", s1MV.getId());
	session.setAttribute("password", s1MV.getPassword());
	session.setAttribute("name", s1MV.getName());
	session.setAttribute("birthday", s1MV.getBirthday());
	session.setAttribute("tel", s1MV.getTel());
	session.setAttribute("postcode", s1MV.getPostcode());
	session.setAttribute("address", s1MV.getAddress());
%>
<script>
	alert("로그인성공")
	location.href = "/jsptest/projectS1/JoinMain.jsp";
</script>
<%
} else {
System.out.println("로그인실패");
%>
<script>
	alert("아이디 혹은 비밀번호가 잘못됨")
	location.href = "/jsptest/projectS1/JoinMain.jsp";
</script>
<%
}
/* response.sendRedirect("JoinMain.jsp"); */
%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> -->