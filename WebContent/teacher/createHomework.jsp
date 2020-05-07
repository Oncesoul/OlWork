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
					<div class="panel-heading" >管理作业</div>
					${msg }
					<div class="panel-body">
						<div style="text-align: right;">
						<a id="refresh" href="${pageContext.request.contextPath }/findwork" type="button" class="btn btn-success"><span class="glyphicon glyphicon-refresh"></span>&nbsp;刷新列表</a>
						<a type="button" class="btn btn-success" data-toggle="modal" data-target="#addModal"><span class="glyphicon glyphicon-plus"></span>&nbsp;添加作业</a></div>
						<nav><ul id="pages" class="pagination"></ul></nav>
						<table class="table">
							<tr>
								<th><center>编号</center></th>
								<th><center>标题</center></th>
								<th><center>状态</center></th>
								<th><center>操作</center></th>
								
							</tr>
							
						<c:forEach var="info" items="${findwork }">
						<tr>
								<th><center><c:out value="${info.works_id }"></c:out></center></th>
								<th><center><c:out value="${info.works_title }"></c:out></center></th>
								<th><center><a  type="button" class="btn btn-sm btn-success" href="${pageContext.request.contextPath }/workinfo?works_id=${info.works_id}">查看</button></center></th>
								<th><center><a  type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#deleteModal" onclick="worksid(${info.works_id},this)"><span class="glyphicon glyphicon-remove"></span>删除</button></center></th>
							</tr>
						</c:forEach>
						
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-lg-3"></div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="deleteLabel" ><span class="glyphicon glyphicon-remove"></span>&nbsp;确认删除</h4>
				</div>
				<div class="modal-body">
					<p>确定要将此作业的所有信息删除？此操作不可撤销！</p>
				</div>
				<div id="deletefooter" class="modal-footer">
					<form id="delTask" action="${pageContext.request.contextPath }/findwork" method="get">
						<input id="workssid" type="hidden" name="works_id" value="" >
						<button type="button" class="btn btn-sm btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-repeat"></span>&nbsp;返回</button>
						<button type="submit"  class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--Model-->

	<!-- Modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="addLabel"><span class="glyphicon glyphicon-plus"></span>&nbsp;添加作业</h4>
				</div>
				<form id="addTask" formname="addTask" method="post" action="${pageContext.request.contextPath }/addwork" onsubmit="replace(this.homework_details)">
					<div class="modal-body">
						<div class="form-group"><label>标题号：</label><input type="text" class="form-control" name="works_id" placeholder="标题号"></div>
						<div class="form-group"><label>作业标题：</label><input type="text" class="form-control" name="works_title" placeholder="作业标题"></div>
						<div class="form-group"><label>截止时间：</label><div class="input-group date form_datetime col-md-5" data-date="2020-02-14 08:00:00" data-date-format="yyyy-mm-dd hh:ii:ss" data-link-field="dtp_input1"><input class="form-control" name="homework_deadline" placeholder="截止时间" size="16" type="text" value="" readonly><span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span></div></div>
						<div class="form-group"><label>详细描述：</label><textarea class="form-control" name="works_content" rows="10" placeholder="详细描述"></textarea></div>
						<input type="hidden" name="work_tid" value="${teacher_id }">
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
	
	<script>
		$("#deleteModal").modal("hide");
		function worksid(worksid,obj) {
			$("#workssid").val(worksid);
		}
	</script>
</body>
</html>