package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import util.DbUtil;

/**
 * Servlet implementation class addCourse_Servlet
 */
@WebServlet("/addCourse_Servlet")
public class addCourse_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addCourse_Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Connection connection = new DbUtil().getCon();
		Statement state = null;
		ResultSet rs = null;
		Student student = (Student) session.getAttribute("student");
		String course_id = request.getParameter("id");
		String course_name = request.getParameter("course_name");
		String course_time = request.getParameter("course_time");
		String course_place = request.getParameter("course_place");
		System.out.println(course_id);
		String sql = "insert into select_course(stu_id,course_id,course_name,course_time,course_place) values("
				+ student.getStu_id() + "," + course_id + "," + course_name + "," + course_time + "," + course_place
				+ ");";
		try {
			state = connection.createStatement();
			state.executeUpdate(sql);// 更改数据库
			sql = "insert into score(stu_id,course_id,stu_name,course_name) values(" + student.getStu_id() + ","
					+ course_id + ",'" + student.getStu_name() + "'," + course_name + ");";
			System.out.println(sql);
			state.executeUpdate(sql);// 更改数据库
			response.sendRedirect("Select_Course.jsp");// 返回选课页面
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
