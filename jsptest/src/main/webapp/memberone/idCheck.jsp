<%@page import="memberone.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    StudentDAO dao = StudentDAO.getInstance();
    String id = request.getParameter("id");
    boolean check = dao.idCheck(id);
    %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ID중복체크</title>
  <link rel="stylesheet" href="style.css" type="text/css">
  <script src="script.js" lang="javascript"></script>
</head>
<body bgcolor="#FFFFCC">
  <br>

    <b><%=id%></b>
    <%
    if(check){
    	out.println("는 이미 존재한는 ID입니다.<br></br>");
    }else{
    	out.println("는 사용 가능합니다.<br></br>");
    }
    %>
    <a href="" onclick="javascript:self.close()">닫기</a>

</body>
</html>