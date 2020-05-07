<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/demo.css" type="text/css" media="all" />
</head>
<body>
<%@ include file = "teacher/navi.jsp" %>
<meta http-equiv="refresh" content="2;url=teacher/addstudent.jsp"> 
<br>
<br>
<br>
<%

String   s   =(String)request.getAttribute("register_err");

%>
<p><%=s %></p>
</body>
</html>