<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
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
				<div class="panel panel-primary">
					<div class="panel-heading" >作业列表</div>
					${msg }
					<div class="panel-body">
						<div style="text-align: right;">
						<a type="button" class="btn btn-success" href="${pageContext.request.contextPath }/homeworkinfo?works_id=${workinfo.works_id}"><span class="glyphicon glyphicon-refresh"></span>&nbsp;刷新</a>
						<a type="button" class="btn btn-success" href="${pageContext.request.contextPath }/submithomework?work_id=${workinfo.works_id }&stu_id=${user.stu_id }"><span class="glyphicon glyphicon-refresh"></span>&nbsp;已提交，点击查看</a></div>
						<nav><ul id="pages" class="pagination"></ul></nav>
						<table class="table">
							<tr>
								<th><center>编号<br><br>${workinfo.works_id }</center></th>
								<th><center>标题<br><br>${workinfo.works_title }</center></th>
								<th><center>内容<br><br>${workinfo.works_content }</center></th>
								<th><center>教师<br><br>${workinfo.work_tid }</center></th>
								<th><center></center></th>
							</tr>
							<tbody id="tasks"></tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-lg-3"></div>
		</div>
	</div>

	<!-- ------------------- -->
	<form action="${pageContext.request.contextPath }/submithomework" method="get">
	<c:forEach items="${choice }" var="info" begin="0"  varStatus="status" >
	<div class="panel panel-primary">
	<div class="panel-heading" ><c:out value="${status.index+1 }：${info.title }"></c:out></div>
					<div class="panel-body">
						<div style="text-align: left;">
						<input type="hidden" value="${info.id }" name="answer_id${status.index }">
						<table class="table">
							<tr>
								<th>A:<c:out value="${info.a }"></c:out></th>
							</tr>
						</table>
						
						<table class="table">
							<tr>
								<th>B:<c:out value="${info.b }"></c:out></th>
							</tr>
						</table>
						
						<table class="table">
							<tr>
								<th>C:<c:out value="${info.c }"></c:out></th>
							</tr>
						</table>
						
						<table class="table">
							<tr>
								<th>D:<c:out value="${info.d }"></c:out></th>
							</tr>
						</table>
						
						<table class="table">
							<tr>
								<th><div class="form-group">
							<label for="name">正确答案</label>
								<select class="form-control" id="answer" name="answer${status.index }">
									<option value="a" >A</option>
									<option value="b" >B</option>
									<option value="c" >C</option>
									<option value="d" >D</option>
								</select>
						</div></th>
							</tr>
						</table>
					</div>
						
	</div></div>
	</c:forEach>
<!-- -------------------论述-------------------- -->
	<c:forEach items="${discuss }" var="info" begin="0"  varStatus="status">
	<div class="panel panel-primary">
	<div class="panel-heading" ><c:out value="${status.index+1 }：${info.discuss_title }"></c:out></div>
					<div class="panel-body">
						<div style="text-align: left;">
						<input type="hidden" value="${info.discuss_id }" name="disanswer_id${status.index }">
						<table class="table">
							<tr>
								<th><c:out value="${info.discuss_content}"></c:out></th>
							</tr>
							<tr>
							<th><div class="form-group"><textarea class="form-control" name="disanswer${status.index }" rows="10" placeholder="请回答"></textarea></div></th>
							</tr>
						</table>
					</div>
						
	</div></div>
	</c:forEach>
	<input type="hidden" name="size" value="${fn:length(choice)}">
	<input type="hidden" name="dissize" value="${fn:length(discuss)}">
	<input type="hidden" name="stu_id" value="${user.stu_id }">
	<input type="hidden" name="work_id" value="${workinfo.works_id }">
	<div style="text-align: center;">
	<input type="submit" class="btn btn-success" value="提交">
	</div>				
	</form>
	<!--Model-->
</body>
</html>