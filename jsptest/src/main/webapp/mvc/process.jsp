<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>요청 파라미터로 명령어를 전달하는 예제</title>
</head>
<body>
	처리 결과:
	<c:set var="message" value="${requestScope.message}" />
	<c:out value="${message}" />
</body>
</html> 