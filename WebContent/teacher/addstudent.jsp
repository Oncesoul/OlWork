<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/demo.css" type="text/css" media="all" />
</head>
<body>
<%@ include file="navi.jsp" %>
<div class="addStu">
<form action="${pageContext.request.contextPath}/register" method="post">
	<p>
	<label>学生学号:&nbsp;</label>
	<input type="text" name="stu_id">
	</p><br />
	<p>
	<label>学生姓名:&nbsp;</label>
	<input type="text" name="stu_name">
	</p><br />
	<p>
	<label>所属教师:&nbsp;</label>
	<input type="text" name="stu_tid">
	</p><br />
	<p>
	<input type="submit" value="添加">
	</p>
</form>
</div>
<div class="container"
		style="justify-content: center; align-items: center; margin-top: 100px">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="panel panel-primary">
					<div class="panel-heading">学生列表</div>
					<div class="panel-body">
						<nav>
							<ul id="pages" class="pagination"></ul>
						</nav>
						<table class="table">
							<tr>
								<th><center>学号<br><br></center></th>
								<th><center>密码</center></th>
								<th><center>姓名</center></th>
								<th><center>教师</center></th>
							</tr>
						
						<c:forEach var="info" items="${userinfo }">
						<tr>
								<th><center><c:out value="${info.stu_id }"></c:out></center></th>
								<th><center><c:out value="${info.stu_password }"></c:out></center></th>
								<th><center><c:out value="${info.stu_name }"></c:out></center></th>
								<th><center><c:out value="${teacher_name }"></c:out></center></th>
							</tr>
						</c:forEach>
						
						</table>
						
						<div style="text-align: right;">
							<a id="refresh" href="${pageContext.request.contextPath }/finduserinfo" type="button" class="btn btn-success"><span class="glyphicon glyphicon-refresh"></span>&nbsp;刷新列表</a>
							
						</div>
						
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>