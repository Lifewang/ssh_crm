<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<title>客户关系管理系统</title>
	
</head>
<body>
	<div id="login_top">
		<div id="welcome">
			欢迎使用CRM客户关系管理系统
		</div>
		<div id="back">
			<a href="#">返回首页</a>&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="#">帮助</a>
		</div>
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="${pageContext.request.contextPath}/user_login.action" method="post">
					<div id="login_tip">
						用户登录&nbsp;&nbsp;
					</div>
					<div><input type="text" class="username" name="username"></div>
					<div><input type="password" class="pwd" name="password"></div>
					<div id="btn_area">
						<input type="submit" name="submit" id="sub_btn" value="登录">&nbsp;&nbsp;
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="login_bottom">
		版权所有
	</div>
</body>
</html>