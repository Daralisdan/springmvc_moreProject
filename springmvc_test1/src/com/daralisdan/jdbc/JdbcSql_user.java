package com.daralisdan.jdbc;

public class JdbcSql_user {
	private String id;
	private String name;
	private String sex;
	private String age;

	public JdbcSql_user() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public JdbcSql_user(String id, String name, String sex, String age) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
}
