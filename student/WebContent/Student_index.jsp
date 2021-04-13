<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生主页面</title>
<style>
.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	padding: 12px 16px;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
<link rel="stylesheet" type="text/css" href="common.css">
</head>
<body style="background-image: url(img/Chemical.svg)">
	<div id="top"></div>
	<div class="top1">
		<form action="Select_Course_Servlet" method="post">
			<p>
				<input class="top2" type="submit" value="自主选课">
			</p>
		</form>
		<form action="Show_CourseList_Servlet" method="post">
			<p>
				<input class="top2" type="submit" value="查询课表">
			</p>
		</form>
		<form action="Search_Score_Servlet" method="post">
			<p>
				<input class="top2" type="submit" value="查询分数">
			</p>
		</form>
		<form action="index.jsp" method="post">
			<p>
				<input class="top3" type="submit" value="返回登录界面">
			</p>
		</form>
	</div>
</body>
</html>