<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>include 지시어를 활용한 예제</h2>

<%@ include file="top.jsp"%>
포함하는 페이지 지시어(include) 예제의 내용입니다. 
<p align="center">작성자<b><%=name%></b> 입니다.</p>
<%=date.toString()%><br></br>
<%@ include file="bottom.jsp"%>