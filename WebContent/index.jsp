<%@ page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <style type="text/css">
	a{ text-decoration:none;
		color:#4D4D4D}
    #head {
        background-color: #F3F3F3;
        height: 70px;
        width: 100%;
    }
#main {
	height: 600px;
	width: 1200px;
	margin: auto;
}
#mainleft {
	float: left;
	height: 450px;
	width: 300px;
	margin-top: 30px;
	margin-left: 30px;
	border-radius: 5px;
	border: 1px solid #F3F3F3;
}
#mainleft_notice {
	background-color: #B5F0BC;
	height: 50px;
	width: 300px;
	font-family: "黑体";
	font-size: 18px;
	line-height: 50px;
	border-radius: 5px;
}
    #headleft {
        float: left;
        height: 70px;
        width: 70px;
        margin-top: auto;
        margin-right: auto;
        margin-bottom: auto;
        margin-left: 400px;
    }
    #toptext {
        font-family: "华文琥珀";
        font-size: 24px;
        line-height: 70px;
        float: left;
        color: #4D4D4D;
    }
    #headright {
	font-family: "华文琥珀";
	color: #4D4D4D;
	background-color: #B5F0BC;
	float: right;
	height: 30px;
	width: 50px;
	margin-right: 400px;
	font-size: 10px;
	line-height: 30px;
	margin-top: 20px;
	border-radius: 5px;
	text-align: center;
}
	#headright a:hover{
	color: #FFFFCC;
	font-size: 12px;
}
	 /*标题样式*/
        p{
            text-align: center;
            font-size: 25px;
            color: cadetblue;
            font-family: fantasy;

        }
#login {
	float: left;
	height: 300px;
	width: 250px;
	margin-top: 30px;
	border: 1px none #F3F3F3;
	border-radius: 5px;
}
#img {
	float: left;
	height: 600px;
	width: 600px;
}

        .imgBox{
	border-top: 2px solid cadetblue;
	width: 500px;
	height: 500px;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
        }
#stulogin {
	height: 50px;
	width: 250px;
	background-color: #B5F0BC;
	border-radius: 5px;
	font-family: "黑体";
	font-size: 18px;
	line-height: 50px;
}

        .imgBox img{
	width: 500px;
	height: 300px;
	padding-top: 30px;
	margin-top: 0;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
        }

        .img1{
            display: block;
        }


        .img2{
            display: none;
        }

        .img3{
            display: none;
        }
        .btns { width:137px; height:33px; background:url("img/login.jpg") no-repeat left top; color:#FFF; border-radius:5px; }
#foot {
	background-color: #F3F3F3;
	height: 200px;
	width: 1200px;
	margin: auto;
	border-radius: 5px;
	font-family: "黑体";
	font-size: 14px;
	line-height: 50px;
	text-align: center;
}
    </style>
    </head>
    <body>
    <div id="head">
        <div id="headleft">
        <a href="index.jsp"><img src="img/logo.png" width="70" height="70"> </a>
        </div>
      <div id="toptext">
        <a href="index.jsp">布朗的在线作业</a> </div>
        <div id="headright">
        <a href="teacher/login.jsp">教师登录</a> </div>
    </div>
    <!--------------------main------------------------------------->
    <div id="main">
    	<div id="mainleft">
        <div id="mainleft_notice">
        最新公告：
        </div>
        <ul>
          <a href="#">【计算机组成原理】课程通知 2020/03/10</a>
        </ul>
        <ul>
          <a href="#">【计算机操作系统】课程通知 2020/02/21</a>
        </ul>
    </div>
      <div id="img"><p>课程展示</p>
<div class="imgBox">
    <img class="img-slide img1" src="img/002.jpg" alt="1">
    <img class="img-slide img2" src="img/003.jpg" alt="2">
    <img class="img-slide img3" src="img/001.jpg" alt="3">
</div></div>
	<div id="login">
   	<div id="stulogin">学生登录</div> 
   	${login_msg}<br>
    <!--${pageContext.request.contextPath }获取当前应用的根  ${pageContext.request.contextPath}/LoginServlet /user/userlogin-->
   	
    <form action="${pageContext.request.contextPath}/login" method="post"><br><br>
    账号：<input type="text" name="stu_id"><br><br>
    密码：<input type="password" name="stu_password"><br><br>
    <input type="submit" class="btns" value="登陆" name="login">
    </form>
    </div>
    </div>
    <!------------foot----------------->
    <div id="foot">
    在线作业系统<br>
    <hr>
    教师请联系管理员<br>
    学生与于本课程教师联系<br>
    </div>
    <p>版权所有 豫ICP备1666666666号-1&nbsp;BY_Once&nbsp;&nbsp;Once </p>
</body>
<script type="text/javascript">
    var index=0;
    //改变图片
    function ChangeImg() {
        index++;
        var a=document.getElementsByClassName("img-slide");
        if(index>=a.length) index=0;
        for(var i=0;i<a.length;i++){
            a[i].style.display='none';
        }
        a[index].style.display='block';
    }
    //设置定时器，每隔两秒切换一张图片
    setInterval(ChangeImg,2000);
</script>
</html>