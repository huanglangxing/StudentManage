<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,model.Teach_course"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>老师查询课表</title>
<link rel="stylesheet" href="teacher.css">

</head>

<body>
	<div class="contentor">
		<div class="header">
			<img src="img/iconf.png" class="image"> <span class="text">
				广州大学教务管理平台 </span>
			<div class="header1">

				<form action="Teacher_index.jsp" method="post">
					<p>
						<input type="submit" value="返回">
					</p>
				</form>
			</div>
		</div>
	</div>

	<div class="center">
		<div class="center2">
			<table border="1" style="border-radius: 15px; color: white;">
				<span style="font-size: 24px; line-height: 60px;">老师已开课程如下</span>
				<%
				ArrayList<Teach_course> list = (ArrayList<Teach_course>) session.getAttribute("teacherCourseList");
				if (list != null && list.size() != 0) {
				%>
				<tr class="tables">
					<th colspan="4" align="center">课程号</th>
					<th colspan="4" align="center">课程名</th>
					<th colspan="4" align="center">课程时间</th>
					<th colspan="4" align="center">课程地点</th>
				</tr>
				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr class="tables">
					<th colspan="4" align="center"><%=list.get(i).getCourse_id()%></th>
					<th colspan="4" align="center"><%=list.get(i).getCourse_name()%></th>
					<th colspan="4" align="center"><%=list.get(i).getTeach_time()%></th>
					<th colspan="4" align="center"><%=list.get(i).getTeach_place()%></th>
				</tr>
				<%
				}
				%>
				<%
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>