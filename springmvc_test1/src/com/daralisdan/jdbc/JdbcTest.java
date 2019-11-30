package com.daralisdan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {

	/**
	 * 查询
	 * 
	 * @throws Exception
	 */
	public void query() throws Exception {
		Connection conn = null;
		try {
			// 1.建立连接
			// 1.1装载驱动类
			Class.forName("oracle.jdbc.driver");
			// 1.2获取跟数据库的连接（连接数据库）
			conn = DriverManager.getConnection("jdbc:", "user", "password");
			// 2输出数据
			// 2.1准备输出数据
			// 2.1.4查询
			String sql4 = "select name,uid as a,age from tb_user";
             String sql6="select name,uid as a,age from tb_user where name like ?";
			// 2.2准备输出的接口
             PreparedStatement pstmt=conn.prepareStatement(sql6);
             String a="2";
             pstmt.setString(1, "%"+a+"%");
             
             
			Statement stmt = conn.createStatement();
			// 2.3真正执行输出
			ResultSet rs6=pstmt.executeQuery();
			
			ResultSet rs = stmt.executeQuery(sql4);
			// 2.4循环从rs里面获取数据，三种不同的获取方式
			while (rs.next()) {
				String uid = rs.getString("a");
				String name = rs.getString(1);
				String age = rs.getString("age");
				System.out.println("uid=" + uid + ",name=" + name + ",age=" + age);
			}
			// 3.输出数据
			// 4.关闭
			stmt.close();
		} finally {
			conn.close();// 关闭数据库
		}
	}

	public void create(UserModel um) throws Exception {
		Connection conn = null;
		try {
			// 1.建立连接
//1.1装载驱动类
			Class.forName("oracle.jdbc.driver");
			// 1.2获取跟数据库的连接（连接数据库）
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:8080:orcl", "user", "password");
			// 2输出数据
			// 2.1准备输出数据
			// 2.1.1增加
			String sql = "insert into tb_user (uid,name,age) value('" + um.getUid() + "','" + um.getName() + "',"
					+ um.getAge() + ")";
			// 2.1.2修改
			String name = "zz";
			String sql2 = "update  tb_user set name='" + name + "' where uid='" + um.getUid() + "'";
			// 2.1.3删除
			String sql3 = "delete from tb_user where uid='" + um.getUid() + "'";

			// 2.1.4 ?表示占位符
			String sql5 = "insert into tb_user (uid,name,age) value(?,?,?) ";
			// 2.2准备输出的接口
			PreparedStatement pstmt = conn.prepareStatement(sql5);
			pstmt.setString(1, um.getUid());
			pstmt.setString(2, um.getName());
			pstmt.setString(3, um.getAge());

			Statement stmt = conn.createStatement();
			// 2.3真正执行输出
			pstmt.executeUpdate(sql5);

			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			// 3.输出数据
			// 4.关闭
			pstmt.close();

			stmt.close();
		} finally {
			conn.close();// 关闭数据库
		}
	}

	public static void main(String[] args) {
		JdbcTest t = new JdbcTest();
		UserModel um = new UserModel();
		um.setUid("1");
		um.setName("haha");
		um.setAge("10");
		try {
			t.create(um);
			t.query();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

class UserModel {
	private String uid;
	private String name;
	private String age;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
