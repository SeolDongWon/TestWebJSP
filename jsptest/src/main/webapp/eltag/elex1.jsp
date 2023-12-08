<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="actiontag.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Customer customer = new Customer();
customer.setName("손오공");
customer.setEmail("son@hamail.net");
customer.setPhone("010-1234-5678");

request.setAttribute("customer", customer);

HashMap<String, String> map1 = new HashMap<String, String>();
map1.put("name", "소나타");
map1.put("maker", "현대자동차");
request.setAttribute("car1", map1);

HashMap<String, String> map2 = new HashMap<String, String>();
map2.put("name", "모닝");
map2.put("maker", "기아자동차");
request.setAttribute("car2", map2);

ArrayList<HashMap> cars1 = new ArrayList<HashMap>();
cars1.add((HashMap<String, String>)request.getAttribute("car1"));
cars1.add((HashMap<String, String>)request.getAttribute("car2"));
request.setAttribute("cars1", cars1);


ArrayList cars2 = new ArrayList();
cars2.add(request.getAttribute("car1"));
cars2.add(request.getAttribute("car2"));
%>
<html>
<head>
<title>EL Example</title>
</head>
<body>
	<ul>
		<li>이름 : <%=customer.getName()%></li>
		<li>메일 : <%=customer.getEmail()%></li>
		<li>전화 : <%=customer.getPhone()%></li>
		<br></br>
		<li>이름 : ${customer.name}</li>
		<li>메일 : ${customer.email}</li>
		<li>전화 : ${customer.phone}</li>
	</ul>
	<br></br>
	<ul>
	<p>\${car1.</p>
		<li>자동차 : ${car1.name}</li>
		<li>제조사 : ${car1.maker}</li>
		<p>\${cars1[0].</p>
		<li>자동차 : ${cars1[0].name}</li>
		<li>제조사 : ${cars1[0].maker}</li>
		<p><\%=map1.get(".</p>
		<li>자동차 : <%=map1.get("name")%></li>
		<li>제조사 : <%=map1.get("maker")%></li>
		<br></br>
<%-- 		<li>자동차 : <%=car.get("name")%></li>
		<li>제조사 : <%=car.get("maker")%></li> --%>
		<br></br>
		<li>자동차 : <%=((HashMap<String, String>) request.getAttribute("car1")).get("name")%></li>
		<%System.out.println(cars1.get(0).get("name")); %>
		<%-- <%System.out.println(cars2.get(0).get("name")); %> --%>
		<%System.out.println(cars2); %>
		<%System.out.println(((HashMap<String, String>)cars2.get(1)).get("name")); %>
		<%-- <li>제조사 : <%=cars.get(0).get("name")%></li> --%>
	</ul>
</body>
</html>