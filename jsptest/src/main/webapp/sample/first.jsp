<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--자바코드구현 멤버변수, 멤버함수 선언-->
<%!
	public String declation = "멤버변수 declation입니다.";
	public String getDeclation() {
		return declation;
	}
	%>
<!--자바코드구현 서비스지역변수선언-->
<%
// Scriptlet - 연산, 처리
	String scriptlet = "scriptlet은 서비스함수에 구현한것입니다.";
	out.println("내장객체를 이용한 출력 : " + this.declation);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP File</title>
</head>


<body>
	<h1>JSP Script 예제</h1>
	<h2>선언문 출력하기 : <%=this.getDeclation() %></h2>

</body>
</html>