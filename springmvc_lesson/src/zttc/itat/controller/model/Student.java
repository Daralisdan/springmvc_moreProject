package zttc.itat.controller.model;

public class Student {
	private String sname;
	private String sid;
	private String age;
	private String sex;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Student(String sname, String sid, String age, String sex) {
		super();
		this.sname = sname;
		this.sid = sid;
		this.age = age;
		this.sex = sex;
	}
	
}
