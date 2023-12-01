<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//컨텍스트 자료 가져오기
Enumeration<String> em = application.getInitParameterNames();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<ul class="list-group">
			<%
			while (em.hasMoreElements()) {
				String paramName = em.nextElement();
				String paramValue = application.getInitParameter(paramName);
			%>
			<li class="list-group-item"><%=paramName%>=<%=paramValue%></li>
			<%
			}
			%>


			<li>키=데이터값</li>
		</ul>
	</div>

</body>
</html>