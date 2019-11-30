package com.daralisdan.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 1.建立与数据库的连接 1.1装在驱动 1.2连接数据库,获得与数据库的连接 2.输出数据 2.1准备输出的数据（增加，修改，删除）
 * 2.2准备输出输出的接口 2.3真正执行输出 3.输出数据 4.关闭接口 5.关闭数据库
 */
public class JdbcSql_Connection {
	/**
	 * 连接数据库
	 * 
	 * @return
	 */
	public static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver"; // 定义一个装载驱动类
		String url = "jdbc:mysql://localhost:3306/stu"; // 声明一个连接数据库的url地址，用户名，密码，静态常量
		String username = "root";
		String password = "123456";
		Connection conn = null; // 连接数据库的一个对象
		try {
			// 1.装在驱动
			Class.forName(driver);
			// 2.连接数据库
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	
}
