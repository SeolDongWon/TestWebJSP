<%@page import="projectS1.S1MemberVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.ConnectionPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="sMVB" class="projectS1.S1MemberVO" />
<jsp:setProperty name="sMVB" property="*" />
<%
S1MemberVO s1MVO = sMVB;
ConnectionPool connPool = null;
Connection conn = null;
StringBuffer sql = new StringBuffer();
PreparedStatement pstmt = null;

connPool = ConnectionPool.getInstance();

try {
	conn = connPool.getConnection();
	sql.append(
	"insert into projects1member(id, password, name, birthday, tel, postcode, address) values(?,?,?,?,?,?,?)");
	pstmt = conn.prepareStatement(sql.toString());
	pstmt.setString(1, s1MVO.getId());
	pstmt.setString(2, s1MVO.getPassword());
	pstmt.setString(3, s1MVO.getName());
	pstmt.setString(4, s1MVO.getBirthday());
	pstmt.setString(5, s1MVO.getTel());
	pstmt.setString(6, s1MVO.getPostcode());
	pstmt.setString(7, s1MVO.getAddress());
	pstmt.executeUpdate();
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	try {
		if (pstmt != null) {
	pstmt.close();
		}
		if (connPool != null) {
	connPool.releaseConnection(conn);
		}
		if (conn != null) {
	conn.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
response.sendRedirect("JoinMain.jsp");
%>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SetMemberList.jsp</title>
</head>
<body>

</body>
</html> -->