<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"     %>
<%!private int numOne = 0;

	public void jspInit() { // 메소드 재정의
		System.out.println("jspInit() 호출됨");
	}

	public void jspDestroy() { // 메소드 재정의
		System.out.println("jspDestroy() 호출됨");
	}%>
<%
int numTwo = 0;
numOne++;
numTwo++;
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>Number One : <%=this.numOne%></li>
		<li>Number Two : <%=numTwo%></li>
	</ul>

</body>
</html>