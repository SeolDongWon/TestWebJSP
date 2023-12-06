<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="view/color.jsp"%>
<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="style.css" type="text/css" />
<script lang="javascript" src="script.js"></script>
<!-- 
function deleteSava(){
	if(document.delForm.pass.value==''){
	alert("비밀번호를 입력하십시요.");
	document.delForm.pass.focus();
	return false;
	}
}

// -->
</head>
<body bgcolor="<%=bodyback_c%>">
	<b>글수정</b>
	<br>
	<form method="post" name="delForm"
		action="deleteProc.jsp?pageNum=<%=pageNum%>"
		onsubmit="return deleteSave()">
		<table width="360" border="1" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30">
				<td align="center" bgcolor="<%=value_c%>"><b>비밀번호를 입력해 주세요.</b></td>
			</tr>
			<tr height="30">
				<td align="center">비밀번호 : <input type="password" name="pass"
					size="8" maxlength="12"> <input type="hidden" name="num"
					value="<%=num%>"></td>
			</tr>
			<tr height="30">
				<td align="center" bgcolor="<%=value_c%>"><input type="submit"
					value="글삭제"> <input type="button" value="글목록"
					onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>