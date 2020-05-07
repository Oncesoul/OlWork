<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/demo.css" type="text/css" media="all" />


</head>
<body>
<%@ include file="navi.jsp" %>

<div class="container-fluid" style="justify-content: center; align-items: center; margin-top: 100px">
		<div class="row">
			<div class="col-md-3 col-lg-3"></div>
			<div class="col-md-6 col-lg-6">
				<div class="panel panel-info">
					<div class="panel-heading" >作业信息</div>
					${msg }
					<div class="panel-body">
						<div style="text-align: right;"></div>
						<nav><ul id="pages" class="pagination"></ul></nav>
						<table class="table">
							<tr class="warning">
								<th><center>编号<br><br>${workinfo.works_id }<br><br></center></th>
								<th><center>标题<br><br>${workinfo.works_title }</center></th>
								<th><center>内容<br><br>${workinfo.works_content }</center></th>
								<th><center>教师<br><br>${teacher_name }</center></th>
								<th><center></center></th>
							</tr>
						</table>
						
						<table class="table">
							<tr class="success">
								<th><center>学号</center></th>
								<th><center>姓名</center></th>
								<th><center>完成情况</center></th>
							</tr>
							
						<c:forEach var="info" items="${userinfo }" >
						<tr>
								<th><center><c:out value="${info.stu_id }"></c:out></center></th>
								<th><center><c:out value="${info.stu_name }"></c:out></center></th>
								<th><center><a id="refresh" href="${pageContext.request.contextPath }/studentcomplet?stu_id=${info.stu_id }&work_id=${workinfo.works_id }&stu_name=${info.stu_name}" type="button" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span>&nbsp;查看</a></center></th>
							</tr>
						</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-lg-3"></div>
		</div>
	</div>

</body>
</html>