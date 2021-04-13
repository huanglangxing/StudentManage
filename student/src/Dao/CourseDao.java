package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Course;
import model.My_Course;
import model.Teach_course;
import util.DbUtil;

public class CourseDao {
	private static Connection conn = null;

	public static ArrayList<Course> Course_List() throws Exception {
		ArrayList<Course> courseList = new ArrayList<Course>();
		conn = new DbUtil().getCon();
		Statement state = null;
		ResultSet rs = null;
		String sql = "select * from course";
		state = conn.createStatement();
		rs = state.executeQuery(sql);
		 while(rs.next()) {
			Course course = new Course();
			course.setCourse_id(rs.getString("course_id"));	
			course.setCourse_name(rs.getString("course_name"));	
			course.setCourse_time(rs.getString("course_time"));
			course.setCourse_place(rs.getString("course_place"));
			course.setTea_name(rs.getString("tea_name"));
			courseList.add(course);
			}
		conn.close();
		return courseList;
	}
	public static ArrayList<My_Course> Show_Course_List(String stu_id) throws Exception{
		ArrayList<My_Course> myCourseList = new ArrayList<My_Course>();
		conn = new DbUtil().getCon();
		Statement state = null;
		ResultSet rs = null;
		String sql = "select * from select_course where stu_id = '" + stu_id + "'";
		state = conn.createStatement();
		System.out.println("准备查询");
		rs = state.executeQuery(sql);
		 while(rs.next()) {
			 My_Course Mycourse = new My_Course();
			 Mycourse.setCourse_id(rs.getString("course_id"));	
			 Mycourse.setStu_id(rs.getString("stu_id"));
			 Mycourse.setCourse_name(rs.getString("course_name"));
			 Mycourse.setCourse_time(rs.getString("course_time"));
			 Mycourse.setCourse_place(rs.getString("course_place"));
			myCourseList.add(Mycourse);
			}
		conn.close();
		return myCourseList;
	}
	public static ArrayList<Teach_course> Show_teacherCourse_List(String tea_id) throws Exception{
		ArrayList<Teach_course> teacherCourseList = new ArrayList<Teach_course>();
		conn = new DbUtil().getCon();
		Statement state = null;
		ResultSet rs = null;
		String sql = "select * from teach_course where tea_id = '" + tea_id + "'";
		state = conn.createStatement();
		System.out.println("准备查询");
		rs = state.executeQuery(sql);
		 while(rs.next()) {
			 Teach_course teach_course = new Teach_course();
			 teach_course.setCourse_id(rs.getString("course_id"));	
			 teach_course.setTea_id(rs.getString("tea_id"));
			 teach_course.setCourse_name(rs.getString("course_name"));
			 teach_course.setTeach_place(rs.getString("teach_place"));
			 teach_course.setTeach_time(rs.getString("teach_time"));
			 teacherCourseList.add(teach_course);
			}
		conn.close();
		return teacherCourseList;
	}
}
