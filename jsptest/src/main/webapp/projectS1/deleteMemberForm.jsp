<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<script>
	function lastCheck() {
		if(!confirm("정말 탈퇴하시겠습니까?")){
			return false;
		}
	}
</script>
<body>
	<form action="deleteMember.jsp" method="post" name="myForm" onsubmit="return lastCheck()">
		<table width="260" align="center">
			<tr>
				<td width="150"><b>비밀번호</b></td>
				<td width="110"><input type="password" name="password" size="15"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="회원탈퇴" > <input type="button" value="취 소"
					onclick="javascript:window.location='JoinMain.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>