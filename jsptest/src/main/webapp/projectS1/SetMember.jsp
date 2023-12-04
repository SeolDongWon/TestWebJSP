<%@page import="projectS1.S1MemberDAO"%>
<%@page import="projectS1.S1MemberVO"%>
<jsp:useBean id="sMVB" class="projectS1.S1MemberVO" />
<jsp:setProperty name="sMVB" property="*" />
<%
S1MemberDAO s1MDA = new S1MemberDAO();
s1MDA.setMemberList(sMVB);
response.sendRedirect("JoinMain.jsp");
%>
