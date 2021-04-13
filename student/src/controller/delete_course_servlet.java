package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CourseDao;
import model.My_Course;
import model.Student;
import util.DbUtil;

/**
 * Servlet implementation class delete_course_servlet
 */
@WebServlet("/delete_course_servlet")
public class delete_course_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public delete_course_servlet() {
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
		Student student = (Student) session.getAttribute("student");
		String stu_id = student.getStu_id();
		String course_id = request.getParameter("id");
		String sql = "delete from select_course where stu_id=" + stu_id + " and course_id=" + course_id + ";";
		System.out.println(sql);
		Connection connection = new DbUtil().getCon();
		Statement state = null;
		try {
			state = connection.createStatement();
			state.executeUpdate(sql);
			sql = "delete from score where stu_id=" + stu_id + " and course_id=" + course_id + ";";
			state.executeUpdate(sql);
			try {
				ArrayList<My_Course> myCourseList = CourseDao.Show_Course_List(student.getStu_id());
				session.setAttribute("myCourseList", myCourseList);// �����session��
				response.sendRedirect("Show_CourseList.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
