package model;

public class Student {
	private String stu_id;
	private String stu_name;
	private String password;
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getPassword() {
		return password;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Student(String stu_id, String stu_name, String password) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.password = password;
	}
	
}
