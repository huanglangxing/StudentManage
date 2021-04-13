<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,model.Teach_course"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<tr>
		<td colspan="4" align="center">老师所授课程如下</td>
	</tr>
	<%
	ArrayList<Teach_course> list = (ArrayList<Teach_course>) session.getAttribute("teacherCourseList");
	if (list != null && list.size() != 0) {
	%>
	<table border="1">
		<tr>
			<td colspan="4" align="center">课程号</td>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td colspan="4" align="center"><%=list.get(i).getCourse_id()%></td>
		</tr>
		<%
		}
		%>
		<%
		}
		%>
	</table>
	<form action="Teacher_index.jsp" method="post">
		<p>
			<input type="submit" value="返回主页面">
		</p>
	</form>
</body>
</html>