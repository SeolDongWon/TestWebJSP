<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>JSTL core 예제 - set, out, remove</title>
</head>
<body>
	<p>browser변수값 설정</p>
	<c:set var="browser" value="${header['User-Agent']}" />
	<br>
	<c:out value="${browser}" />
	<p>		browser변수값 제거 후</p>
		<c:remove var="browser" />
		<c:out value="${browser}" />
</body>
</html>