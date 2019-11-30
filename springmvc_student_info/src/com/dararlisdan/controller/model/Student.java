package com.dararlisdan.controller.model;

public class Student {
	private String sid;
	private String sname;
	private String age;
	private String sex;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getSid() {
		return sid;
	}
	
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public Student( String sid,String sname, String age, String sex) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.sex = sex;
	}
}
