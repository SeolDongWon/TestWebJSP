<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="boardone.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="view/color.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="style.css" type="text/css" />
<script lang="javascript" src="script.js"></script>
</head>
<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
try {
	BoardDAO dbPro = BoardDAO.getInstance();
	BoardVO article = dbPro.getArticle(num);
%>


<body bgcolor="<%=bodyback_c%>">
	<b>글수정</b>
	<br>
	<form method="post" name="writeform"
		action="updateProc.jsp?pageNum=<%=pageNum%>"
		onsubmit="return writeSave()">

		<table width="400" border="1" cellpadding="0" cellspacing="0"
			align="center" bgcolor="<%=bodyback_c%>">
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">이름</td>
				<td width="330"><input type="text" size="10" maxlength="10"
					name="writer" value="<%=article.getWriter()%>" /><input
					type="hidden" name="num" value="<%=num%>"></td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">제목</td>
				<td align="left" width="330"><input type="text" size="40"
					maxlength="50" name="subject" value="<%=article.getSubject()%>" />
				</td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">Email</td>
				<td align="left" width="330"><input type="text" size="40"
					maxlength="30" name="email" value="<%=article.getEmail()%>" /></td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">내용</td>
				<td align="left" width="330"><textarea name="content" rows="13"
						cols="50" value="<%=article.getContent()%>"></textarea></td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">비밀번호</td>
				<td align="left" width="330"><input type="password" size="8"
					maxlength="12" name="pass" /></td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="<%=value_c%>" align="center"><input
					type="submit" value="글수정" /> <input type="reset" value="다시작성" />
					<input type="button" value="목록보기"
					onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'"></td>
			</tr>
		</table>
		<%
		} catch (Exception e) {
		}
		%>
	</form>
</body>
</html>