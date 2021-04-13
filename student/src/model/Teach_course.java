package model;

public class Teach_course {
	private String tea_id;
	private String course_id;
	private String teach_time;
	private String course_name;
	private String teach_place;
	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getTeach_time() {
		return teach_time;
	}
	public void setTeach_time(String teach_time) {
		this.teach_time = teach_time;
	}
	public Teach_course(String tea_id, String course_id, String teach_time) {
		super();
		this.tea_id = tea_id;
		this.course_id = course_id;
		this.teach_time = teach_time;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getTeach_place() {
		return teach_place;
	}
	public void setTeach_place(String teach_place) {
		this.teach_place = teach_place;
	}
	public Teach_course() {
		super();
		// TODO Auto-generated constructor stub
	}
}
