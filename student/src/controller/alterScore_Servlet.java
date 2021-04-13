package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Score;
import util.DbUtil;

/**
 * Servlet implementation class alterScore_Servlet
 */
@WebServlet("/alterScore_Servlet")
public class alterScore_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public alterScore_Servlet() {
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
		String newscore = request.getParameter("newscore");
		String stu_id = request.getParameter("stu_id");
		System.out.println(stu_id);
		String course_id = request.getParameter("course_id");
		System.out.println(newscore);
		ArrayList<Score> detailCourseScore = new ArrayList<Score>();
		String sql = "update Score set score='" + newscore + "'where stu_id=" + stu_id + "and course_id=" + course_id
				+ ";";
		String course_name=null;
		try {
			state = connection.createStatement();
			state.executeUpdate(sql);// 更改数据库
			// response.sendRedirect("TeacherShow_DetialScore.jsp");// 返回成绩页面
			// 改动
			sql="select * from score where course_id=" + course_id + ";";
			rs = state.executeQuery(sql);// 查找数据库
			while (rs.next()) {
				Score score = new Score();
				score.setCourse_id(rs.getString("course_id"));
				score.setStu_id(rs.getString("stu_id"));
				score.setScore(rs.getString("score"));
				score.setStu_name(rs.getString("stu_name"));
				detailCourseScore.add(score);
			}
			sql="select * from course where course_id=" + course_id + ";";
			rs = state.executeQuery(sql);// 查找数据库
			if(rs.next()) {
				course_name=rs.getString("course_name");
			}
			session.setAttribute("course_name",course_name );
			session.setAttribute("detailCourseScore", detailCourseScore);// 保存进session里
			connection.close();
			response.sendRedirect("TeacherShow_DetialScore.jsp");// 返回更改后的成绩页面
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
