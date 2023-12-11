<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원탈퇴</title>
</head>
<meta http-equiv="Refresh" content="3;url=member.mdo?cmd=login" charset="UTF-8">
<body>
	<c:choose>
		<c:when test="${check eq 1}">
			<font size="5" face="바탕체"> 회원정보가 삭제되었습니다<br></br> 안녕히 가세요 ! ㅠ.ㅠ<br></br>
				3초후에 로그인 페이지로 이동합니다
			</font>		
		</c:when>
		<c:when test="${check eq 0}">
			<script>
				alert("비밀번호가 맞지 않습니다");
				history.go(-1);
			</script>
		</c:when>
		<c:otherwise>
			오류발생
		</c:otherwise>
	</c:choose>
</body>
</html>