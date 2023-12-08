<%@page import="actiontag.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<String> singer = new ArrayList<String>();

singer.add("소녀시대");
singer.add("원더걸스");

request.setAttribute("singer", singer);

Customer[] customer = new Customer[2];
customer[0] = new Customer();

customer[0].setName("손오공");
customer[0].setEmail("son@hamail.net");
customer[0].setPhone("010-1234-5678");

customer[1] = new Customer();

customer[1].setName("홍길동");
customer[1].setEmail("hong@hamail.net");
customer[1].setPhone("010-9876-5432");

request.setAttribute("customer", customer);
ArrayList<String> a = ((ArrayList<String>)request.getAttribute("singer"));
String name = a.get(0);
%>
<html>
<head>
<title>EL Example</title>
</head>
<body>
	<ul>
		<li>${singer[0]},${singer[1]}</li>
		<li><%=((ArrayList<String>)request.getAttribute("singer")).get(0) %></li>
		<li><%=a.get(0) %></li>
		<li><%=name %></li>
	</ul>
	<ul>
		<li>이름 : ${customer[0].name}</li>
		<li>메일 : ${customer[0].email}</li>
		<li>전화 : ${customer[0].phone}</li>
	</ul>
	<ul>
		<li>이름 : ${customer[1].name}</li>
		<li>메일 : ${customer[1].email}</li>
		<li>전화 : ${customer[1].phone}</li>
	</ul>
	<ul>
		<% for(int i=0;i<customer.length;i++){  %>
		<li>이름 : <%=customer[i].getName() %></li>
		<li>메일 : <%=customer[i].getEmail() %></li>
		<li>전화 : ${customer[i].phone}</li>
		<%} %>
	</ul>
</body>
</html>