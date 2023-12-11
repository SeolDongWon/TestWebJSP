<%@page import="memberone.StudentDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ID중복체크</title>
<link rel="stylesheet" href="style.css?ver=1" " type="text/css">
<script src="script.js" lang="javascript"></script>
</head>
<body bgcolor="#FFFFCC">
	<br>

	<b>${id}</b>
	<c:if test="${check eq true }">
    	는 이미 존재하는 ID입니다.<br />
	</c:if>
	<c:if test="${check ne true }">
    	는 사용가능합니다.<br />
	</c:if>
	<a href="" onclick="javascript:self.close()">닫기</a>

</body>
</html>