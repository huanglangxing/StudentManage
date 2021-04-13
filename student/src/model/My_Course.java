package model;

public class My_Course {
	private String course_id;
	private String stu_id;
	private String course_name;
	private String course_time;
	private String course_place;
	public String getCourse_id() {
		return course_id;
	} 
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_time() {
		return course_time;
	}
	public void setCourse_time(String course_time) {
		this.course_time = course_time;
	}
	public String getCourse_place() {
		return course_place;
	}
	public void setCourse_place(String course_place) {
		this.course_place = course_place;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public My_Course(String course_id, String stu_id) {
		super();
		this.course_id = course_id;
		this.stu_id = stu_id;
	}
	public My_Course() {
		super();
		// TODO Auto-generated constructor stub
	}
}
