<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="navi.jsp" %>

<div class="container"
		style="justify-content: center; align-items: center; margin-top: 100px">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="panel panel-primary">
					<div class="panel-heading">作业列表${msg }</div>
					<div class="panel-body">
						<nav>
							<ul id="pages" class="pagination"></ul>
						</nav>
						<table class="table">
							<tr>
								<th><center>编号</center></th>
								<th><center>标题</center></th>
								<th><center>概要</center></th>
								<th><center>操作</center></th>
							</tr>
							<c:forEach items="${findhomework }" var="info">
							<tr>
								<th><center>${info.works_id }</center></th>
								<th><center>${info.works_title }</center></th>
								<th><center>${info.works_content }</center></th>
								<th><center><a type="button" class="btn btn-sm btn-danger" href="${pageContext.request.contextPath }/homeworkinfo?works_id=${info.works_id}" ><span class="glyphicon glyphicon-plus"></span>&nbsp;查看</button></center></th>
							</tr>
							</c:forEach>
							<tbody id="tasks"></tbody>
						</table>
					
						<div style="text-align: right;">
							<a id="refresh" type="button" href="${pageContext.request.contextPath }/findhomework?teacher_id=${user.stu_tid}" class="btn btn-success"><span class="glyphicon glyphicon-refresh"></span>&nbsp;刷新列表</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>

</body>
</html>