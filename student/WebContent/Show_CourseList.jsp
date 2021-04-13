<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,model.My_Course"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>学生课表</title>
<link rel="stylesheet" href="teacher.css">

</head>

<body>
	<div class="contentor">
		<div class="header">
			<img src="img/iconf.png" class="image"> <span class="text">
				广州大学教务管理平台 </span>
			<div class="header1">

				<form action="Student_index.jsp" method="post">
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
				<span style="font-size: 24px; line-height: 60px;">学生已选课程如下</span>
				<%
				ArrayList<My_Course> list = (ArrayList<My_Course>) session.getAttribute("myCourseList");
				if (list != null && list.size() != 0) {
				%>
				<tr class="tables">
					<th colspan="4" align="center">课程号</th>
					<th colspan="4" align="center">课程名</th>
					<th colspan="4" align="center">上课时间</th>
					<th colspan="4" align="center">上课地点</th>
				</tr>
				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr class="tables">
					<th colspan="4" align="center"><%=list.get(i).getCourse_id()%></th>
					<th colspan="4" align="center"><%=list.get(i).getCourse_name()%></th>
					<th colspan="4" align="center"><%=list.get(i).getCourse_time()%></th>
					<th colspan="4" align="center"><%=list.get(i).getCourse_place()%></th>
					<th colspan="4" align="center">
						<form
							action="delete_course_servlet?id='+<%=list.get(i).getCourse_id()%>'&course_name='+<%=list.get(i).getCourse_name()%>'
					&course_time='+<%=list.get(i).getCourse_time()%>'&course_place='+<%=list.get(i).getCourse_place()%>'"
							method="post">
							<input type="submit" onclick="alertMassage()" value="退选">
						</form>
					</th>
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
<script>
	function alertMassage() {
		alert("退课成功");
	}
</script>