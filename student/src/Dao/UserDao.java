package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Admin;
import model.Student;
import model.Teacher;
import util.DbUtil;

public class UserDao {
	private static Connection conn = null;

	public static Student findstudent(String stu_id) throws Exception {// 查找学生
		conn = new DbUtil().getCon();
		Statement state = null;
		ResultSet rs = null;
		Student student = new Student();
		try {
			String sql = "select * from student where stu_id = '" + stu_id + "'";
			System.out.println(sql);
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				student.setStu_id(rs.getString("stu_id"));
				System.out.println(student.getStu_id());
				student.setPassword(rs.getString("password"));
				System.out.println(student.getPassword());
				student.setStu_name(rs.getString("stu_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return student;
	}

	public static boolean addStudent(Student student) {// 增加学生
		boolean flag = false;
		int i = 0;
		try {
			conn = new DbUtil().getCon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement state = null;
		String sql = "insert into student (stu_id,stu_name,password) values('" + student.getStu_id() + "','"
				+ student.getStu_name() + "','" + student.getPassword() + "')";
		try {
			state = conn.createStatement();
			i = state.executeUpdate(sql);
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static Teacher findteacher(String tea_id) throws Exception {// 查找管理员
		conn = new DbUtil().getCon();
		Statement state = null;
		ResultSet rs = null;
		Teacher teacher = new Teacher();
		try {
			String sql = "select * from teacher where tea_id = '" + tea_id + "'";
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				teacher.setTea_id(rs.getString("tea_id"));
				teacher.setPassword(rs.getString("password"));
				teacher.setTea_name(rs.getString("tea_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return teacher;
	}
	
	public static Admin findadmin(String admin_id) throws Exception {// 查找学生
		conn = new DbUtil().getCon();
		Statement state = null;
		ResultSet rs = null;
		Admin admin = new Admin();
		try {
			String sql = "select * from admin where admin_id = '" + admin_id + "'";
			System.out.println(sql);
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				admin.setAdmin_id(rs.getString("admin_id"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_password(rs.getString("admin_password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return admin;
	}

	public static void closeConnection() throws Exception {// 断开连接
		conn.close();
	}

}
