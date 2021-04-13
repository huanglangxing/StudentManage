<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>老师主页面</title>
<link rel="stylesheet" type="text/css" href="common.css">
</head>
<body style="background-image:url(img/Chemical.svg)">
	<div class="top1">
		<img class="top_picture" src="img/1.png" />

		<form action="ShowTeacher_course_Servlet" method="post">
			<input class="top2" type="submit" value="查询课表">
		</form>

		<form action="TeacherShowScore_Servlet" method="post">
			<input class="top2" type="submit" value="成绩">
		</form>

		<form action="index.jsp" method="post">
			<input class="top3" type="submit" value="返回登录界面">
		</form>
	</div>
 
	<div class="distance"></div>
	<div id="top">
		
	</div>
</body>
</html>