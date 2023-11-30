<%@ page contentType="text/html; charset=euc-kr"%>
<html>
<head>
<title>클라이언트 및 서버 정보</title>
</head>
<body>
	클라이언트IP =
	<%=request.getRemoteAddr()%>
	<br></br> 요청정보길이 =
	<%=request.getContentLength()%>
	<br></br> 요청정보 인코딩 =
	<%=request.getCharacterEncoding()%>
	<br></br> 요청정보 컨텐트타입 =
	<%=request.getContentType()%>
	<br></br> 요청정보 프로토콜 =
	<%=request.getProtocol()%>
	<br></br> 요청정보 전송방식 =
	<%=request.getMethod()%>
	<br></br> 요청 URL =
	<%=request.getRequestURL().toString()%>
	<br></br> 요청 URI =
	<%=request.getRequestURI()%>
	<br></br> 컨텍스트 경로 =
	<%=request.getContextPath()%>
	<br></br> 서버이름 =
	<%=request.getServerName()%>
	<br></br> 서버포트 =
	<%=request.getServerPort()%>
	<br></br>
</body>
</html>