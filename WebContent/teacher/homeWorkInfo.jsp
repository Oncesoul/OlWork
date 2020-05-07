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
						<a id="refresh" h type="button" class="btn btn-success" data-toggle="modal" data-target="#choiceModal"><span class="glyphicon glyphicon-plus"></span>&nbsp;单选题</a>
						<a type="button" class="btn btn-success" data-toggle="modal" data-target="#discussModal"><span class="glyphicon glyphicon-plus"></span>&nbsp;论述题</a>
						<a type="button" class="btn btn-success" href="${pageContext.request.contextPath }/teacher/workCompletInfo.jsp"><span class="glyphicon glyphicon-pencil"></span>&nbsp;作业情况</a>
						<a type="button" class="btn btn-success" href="${pageContext.request.contextPath }/workinfo?works_id=${workinfo.works_id}"><span class="glyphicon glyphicon-refresh"></span>&nbsp;刷新</a></div>
						<nav><ul id="pages" class="pagination"></ul></nav>
						<table class="table">
							<tr>
								<th><center>编号<br><br>${workinfo.works_id }</center></th>
								<th><center>标题<br><br>${workinfo.works_title }</center></th>
								<th><center>内容<br><br>${workinfo.works_content }</center></th>
								<th><center>教师<br><br>${teacher_name }</center></th>
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

	<!-- Modal -->
	<div class="modal fade" id="choiceModal" tabindex="-1" role="dialog" aria-labelledby="addLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="addLabel"><span class="glyphicon glyphicon-plus"></span>&nbsp;添加作业</h4>
				</div>
				<form id="addTask" formname="addTask" method="post" action="${pageContext.request.contextPath }/addchoice" onsubmit="replace(this.homework_details)">
					<div class="modal-body">
						<div class="form-group"><label>标题：</label><input type="text" class="form-control" name="title" placeholder="输入题目"></div>
						<div class="form-group"><label>选项A：</label><input type="text" class="form-control" name="a" placeholder="输入选项A"></div>
						<div class="form-group"><label>选项B：</label><input type="text" class="form-control" name="b" placeholder="输入选项B"></div>
						<div class="form-group"><label>选项C：</label><input type="text" class="form-control" name="c" placeholder="输入选项C"></div>
						<div class="form-group"><label>选项D：</label><input type="text" class="form-control" name="d" placeholder="输入选项D"></div>
						<div class="form-group">
							<label for="name">正确答案</label>
								<select class="form-control" id="answer" name="answer">
									<option value="a" >A</option>
									<option value="b" >B</option>
									<option value="c" >C</option>
									<option value="d" >D</option>
								</select>
						</div>
						<input type="hidden" name="work_id" value="${workinfo.works_id }">
					</div>
					<div id="deletefooter" class="modal-footer">
						<button type="submit" class="btn btn-sm btn-success"><span class="glyphicon glyphicon-ok"></span>&nbsp;保存</button>
						<button type="button" class="btn btn-sm btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span>&nbsp;放弃</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<!-- ------------------- -->

	<c:forEach items="${choice }" var="info" begin="0"  varStatus="status">
	<div class="panel panel-info">
	<div class="panel-heading" ><c:out value="${status.index+1 }.${info.title }"></c:out></div>
					<div class="panel-body">
						<div style="text-align: left;">
						
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
							<tr class="warning">
								<th>ANSER:<c:out value="${info.answer }"></c:out></th>
								<th><center><a  type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#deleteModal" onclick="worksid(${info.id},this)"><span class="glyphicon glyphicon-remove"></span>删除</button></center></th>	
							</tr>
							
						</table>
					</div>
						
	</div></div>
	</c:forEach>
<!-- -------------------论述-------------------- -->
	<c:forEach items="${discuss }" var="info" begin="0"  varStatus="status">
	<div class="panel panel-info">
	<div class="panel-heading" ><c:out value="${status.index+1 }.${info.discuss_title }"></c:out></div>
					<div class="panel-body">
						<div style="text-align: left;">
						
						<table class="table">
							<tr>
								<th><c:out value="${info.discuss_content}"></c:out></th>
							</tr>
							<tr><th><center><a  type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#deletedisModal" onclick="discussid(${info.discuss_id},this)"><span class="glyphicon glyphicon-remove"></span>删除</button></center></th>
							</tr>
						</table>
					</div>
						
	</div></div>
	</c:forEach>
	
	<!-- Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="deleteLabel" ><span class="glyphicon glyphicon-remove"></span>&nbsp;确认删除</h4>
				</div>
				<div class="modal-body">
					<p>确定要将这道题删除？此操作不可撤销！</p>
				</div>
				<div id="deletefooter" class="modal-footer">
					<form id="delTask" action="${pageContext.request.contextPath }/workinfo?works_id=${workinfo.works_id}" method="get">
						<input id="workssid" type="hidden" name="choice_id" value="" >
						<input type="hidden" name="works_id" value="${workinfo.works_id }">
						<button type="button" class="btn btn-sm btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-repeat"></span>&nbsp;返回</button>
						<button type="submit"  class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--Model-->
	
	<!-- Modal -->
	<div class="modal fade" id="deletedisModal" tabindex="-1" role="dialog" aria-labelledby="deleteLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="deleteLabel" ><span class="glyphicon glyphicon-remove"></span>&nbsp;确认删除</h4>
				</div>
				<div class="modal-body">
					<p>确定要将这道题删除？此操作不可撤销！</p>
				</div>
				<div id="deletefooter" class="modal-footer">
					<form id="delTask" action="${pageContext.request.contextPath }/workinfo" method="get">
						<input id="discussid" type="hidden" name="discuss_id" value="" >
						<input type="hidden" name="works_id" value="${workinfo.works_id }">
						<button type="button" class="btn btn-sm btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-repeat"></span>&nbsp;返回</button>
						<button type="submit"  class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--Model-->
				
	<!--Model-->
		<div class="modal fade" id="discussModal" tabindex="-1" role="dialog" aria-labelledby="addLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="addLabel"><span class="glyphicon glyphicon-plus"></span>&nbsp;添加作业</h4>
				</div>
				<form id="addTask" formname="addTask" method="post" action="${pageContext.request.contextPath }/adddiscuss" onsubmit="replace(this.homework_details)">
					<div class="modal-body">
						<div class="form-group"><label>标题：</label><input type="text" class="form-control" name="discuss_title" placeholder="请输入题目"></div>
						<div class="form-group"><label>作业内容：</label><textarea class="form-control" name="discuss_content" rows="10" placeholder="请输入作业内容"></textarea></div>
						<input type="hidden" name="work_id" value="${workinfo.works_id }">
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
		$("#deletedisModal").modal("hide");
		function discussid(worksid,obj) {
			$("#discussid").val(worksid);
		}
	</script>
</body>
</html>