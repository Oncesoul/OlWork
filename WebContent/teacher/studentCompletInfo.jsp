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
				<div class="panel panel-info">
					<div class="panel-heading" >${workinfo.works_title }：单选题(${comstu_name })</div>
					${msg }
					<div class="panel-body">
						<div style="text-align: right;"></div>
						<nav><ul id="pages" class="pagination"></ul></nav>
						<table class="table">
							<tr>
							<th><center>题目<br><br></center></th>
							<th><center>正确答案<br><br></center></th>
							<th><center>${comstu_name }的答案<br><br></center></th>
							<th><center><br><br></center></th>
							</tr>
							<c:set var="a" value="${0 }"></c:set>
							<c:forEach items="${cwork }" var="info" begin="0"  varStatus="status">
							<tr>
							<th>${status.index+1}：${info.title }</th>
							<th><center>${info.answer }</center></th>
							<th><center>${info.c_answer }</center></th>
							<th><center><c:if test="${info.answer eq info.c_answer}"><c:set var="a" value="${a+1 }"></c:set><span class="glyphicon glyphicon-ok"></span></c:if>
										<c:if test="${info.answer ne info.c_answer}"><span class="glyphicon glyphicon-remove"></span></c:if></center></th>
							</tr>
							</c:forEach>
							<tr>
							<th><center><br><br></center></th>
							<th><center><br><br></center></th>
							<th><center><br><br></center></th>
							<th><center><br>学生${comstu_name }做对了${a }道<br></center></th>
							</tr>
							<tbody id="tasks"></tbody>
						</table>
					</div>
				</div>
				
				<div class="panel panel-info">
					<div class="panel-heading" >${workinfo.works_title }：论述题(${comstu_name })</div>
					${msg }
					<div class="panel-body">
						<div style="text-align: right;">
						<nav><ul id="pages" class="pagination"></ul></nav>
						<table class="table">
							<tr>
							<th><center>题目<br><br></center></th>
							<th><center><a type="button" class="btn btn-sm btn-success" data-toggle="modal" data-target="#addModal" ><span class="glyphicon glyphicon-plus"></span>&nbsp;点评</a><br><br></center></th>
							</tr>
							<c:forEach items="${dwork }" var="info" begin="0"  varStatus="status">
							<tr>
							<th>${status.index+1}：${info.discuss_title }</th>
							<c:set var="dis_id" value="${info.discuss_id }"></c:set>
							<th><center></center></th>
							</tr>
							<tr class="warning">
							<th>&nbsp;&nbsp;&nbsp;&nbsp;${info.answer }</th>
							</tr>
							</c:forEach>
							
							<tbody id="tasks"></tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-lg-3"></div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="addLabel"><span class="glyphicon glyphicon-plus"></span>&nbsp;点评</h4>
				</div>
				<form id="addTask" formname="addTask" method="post" action="${pageContext.request.contextPath }/assessdiswork" onsubmit="replace(this.homework_details)">
					<div class="modal-body">
					<c:forEach items="${dwork }" var="info" begin="0"  varStatus="status">
						<div class="form-group"><label>第${status.index+1 }题得分：</label><input type="text" class="form-control" name="grade${status.index }" placeholder="请填写第${status.index+1 }题成绩，用整数表示"></div>
						<div class="form-group"><label>详细描述：</label><textarea class="form-control" name="assess${status.index }" rows="10" placeholder="详细描述"></textarea></div>
						<input type="hidden" name="gs_id" value="${info.stu_id }">
						<input type="hidden" name="dis_id${status.index }" value="${info.discuss_id }">
					</c:forEach>
						<input type="hidden" name="dissize" value="${fn:length(discuss)}">
					</div>
					<div id="deletefooter" class="modal-footer">
						<button type="submit" class="btn btn-sm btn-success"><span class="glyphicon glyphicon-ok"></span>&nbsp;保存</button>
						<button type="button" class="btn btn-sm btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span>&nbsp;放弃</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!--Model-->
</body>
</html>