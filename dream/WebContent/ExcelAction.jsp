<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.excel.User" %>
<%@ page import="com.excel.ExcelWriter" %>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	int age  = Integer.parseInt(request.getParameter("age"));
	String year = request.getParameter("year");
	String phone = request.getParameter("phone");
	
	User usr = new User(name,age,year,phone);
	
	ExcelWriter writer = ExcelWriter.getInstance();
	
	writer.studentWriter();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	EXCEL로 생성이 완료되었습니다!
</body>
</html>