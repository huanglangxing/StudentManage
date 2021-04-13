package model;

public class Score {
	private String course_id;
	private String stu_id;
	private String score;
	private String stu_name;
	private String course_name;
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Score(String course_id, String stu_id, String score) {
		super();
		this.course_id = course_id;
		this.stu_id = stu_id;
		this.score = score;
	}
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
}
