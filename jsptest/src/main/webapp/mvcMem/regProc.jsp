<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body bgcolor="#FFFFCC">
	<br/>
	<c:set var="flag" value="${flag}"/>
	<c:choose>
		<c:when test="${flag}">
			<b>회원가입을 축하 드립니다.</b><br/>
			<a href="member.mdo?cmd=login">로그인</a>
		</c:when>
		<c:otherwise>
			<b>다시 입력하여 주십시오.</b><br/>
			<a href="member.mdo?cmd=regForm">다시 가입</a>
		</c:otherwise>
	</c:choose>
</body>
</html>
