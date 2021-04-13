package model;

public class Course {
	private String course_id;
	private String course_name;
	private String course_time;
	private String course_place;
	private String tea_name;
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public String getCourse_time() {
		return course_time;
	}
	public void setCourse_time(String course_time) {
		this.course_time = course_time;
	}
	public Course(String course_id, String course_name, String course_time, String course_place, String tea_name) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_time = course_time;
		this.course_place = course_place;
		this.tea_name = tea_name;
	}
	public String getCourse_place() {
		return course_place;
	}
	public void setCourse_place(String course_place) {
		this.course_place = course_place;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

}
