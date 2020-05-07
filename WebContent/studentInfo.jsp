<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="navi.jsp" %>

	<div class="container" style="justify-content: center; align-items: center; margin-top: 100px; font-size: 120%">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h1 class="text-center">个人信息</h1>
				<h2></h2>
				<table class="table table-striped table-bordered">
					<tr>
						<td><center><b>学&nbsp;号</b></center></td>
						<td id="sid">${user.stu_id}</td>
						<td><center></center></td>
					</tr>
					<tr>
						<td><center><b>姓&nbsp;名</b></center></td>
						<td id="name"><font>${user.stu_name}</font></td>
						<td><center></center></td>
					</tr>
					<tr>
						<td><center><b>密&nbsp;码</b></center></td>
						<td>●●●●●</td>
						<td><center><button type="button" class="btn btn-xs btn-warning" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-edit"></span>&nbsp;修改</button></center></td>
					</tr>
				</table>
				<p></p>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;修改密码</h4>
				</div>
				<div class="modal-body">
					<div id="progress" style="display:none">
						<div>
							<p class="text-center"><strong>正在修改密码...</strong></p>
						</div>
						<div class="progress">
							<div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
						</div>
					</div>
					<form id="updatePassword" method="post" action="${pageContext.request.contextPath }/updatepassword">
						<div class="form-group">
							<label for="username">当前用户：</label> <input id="user" type="text" class="form-control" value="${user.stu_name }" disabled="true">
						</div>
						<div class="form-group">
							<label for="oldPassword">当前密码：</label> <input type="password" class="form-control" id="oldPassword" name="old_password" placeholder="您账户的当前密码">
						</div>
						<div class="form-group">
							<label for="newPassword">新密码：</label> <input type="password" class="form-control" id="password" name="stu_password" placeholder="新密码">
						</div>
						<div class="form-group">
							<label for="confirmPassword">确认密码：</label> <input type="password" class="form-control" id="confirmPassword" name="newPassword" placeholder="再次输入您的新密码">
						</div>
						<input type="hidden" name="stu_id" value="${user.stu_id}">
						<div id="modal-footer" class="modal-footer">
							<button id="reset" type="reset" class="btn btn-sm btn-default"> <span class="glyphicon glyphicon-repeat"></span>&nbsp;清空</button>
							<button id="save" type="submit" class="btn btn-sm btn-success"><span class="glyphicon glyphicon-ok"></span>&nbsp;保存</button>
							<button type="button" class="btn btn-sm btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span>&nbsp;放弃</button>
						</div>
					</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>