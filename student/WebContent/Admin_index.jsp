<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>登录界面</title>
<link rel="stylesheet" href="style.css">
<style type="text/css">
#logininput1 {
	position: absolute;
	margin-top: 53px;
	padding-left: 16px;
	line-height: 18px;
}
</style>
</head>

<body>
	<div id="loginBox">
		<span class="cont-one">
			<h3 style="color: #369; font-size: 16px;">人工服务</h3> <br>
			&nbsp;&nbsp;服务部门：广州大学网络与现代教育技术中心<br> &nbsp;&nbsp;办公地点：图书馆副楼3楼<br>
			&nbsp;&nbsp;办公时间：周一至周五上午08:00-12:00<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下午13:30-16:30<br>
			&nbsp;&nbsp;服务电话：39366372/39366373<br>
			&nbsp;&nbsp;服务邮箱：service@gzhu.edu.cn<br> &nbsp;&nbsp;<strong
			style="color: #369;">如登录出现问题，请联系管理员</strong><br>
		</span> <span class="cont-three">
			<h3 style="color: #369; font-size: 16px;">当前时间为选课高峰期，由于带宽、服务器设备资源有限，平台可能会出现响应较慢的现象。</h3>
		</span>

		<div id="login">
			<div id="logininput1">
				<form action="admin_alterPassword" method="post">
					<label for="name"> 用户名：</label> <input name="userid" type="text"
						onBlur="f0()" /><br> <label for="password">新的密码：</label><br>
					<input name="password" type="password" onBlur="f1()" /> <input
						type="submit" onclick="alertMassage()" value="修改密码">
				</form>
			</div>
		</div>
	</div>
	<div class="footer">
		<hr style="color: #369;">
		<hr>
		<span style="color: #FF6600;"> 版权所有© </span> <a
			href="http://www.gzhu.edu.cn/" style="color: #369;"> <strong>
				广州大学 </strong>
		</a> <br> 技术支持广州大学软件185班第四小组
	</div>
</body>

</html>
<script>
	function alertMassage() {
		alert("修改密码成功");
	}
</script>