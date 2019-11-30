package com.daralisdan.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 1.建立与数据库的连接
 * 1.1装在驱动
 * 1.2连接数据库,获得与数据库的连接 
 * 2.输出数据
 * 2.1准备输出的数据（增加，修改，删除）
 * 2.2准备输出输出的接口
 * 2.3真正执行输出
 * 3.输出数据
 * 4.关闭接口
 * 5.关闭数据库
 */
public class JdbcSql_delete {
//定义一个私有的静态方法
public static int delete(String name) throws SQLException {
		//创建一个连接数据库的接口，连接数据库
		Connection conn=JdbcSql_Connection.getConn();
		//输出数据 条件，，，删除
		String sql="delete from user where name='"+name+"'";
		/**
		 * 两种输出数据的方式
		 */
		/*1.准备输出数据的接口
		PreparedStatement pstmt=conn.prepareStatement(sql);
		//关闭输出数据的接口
		pstmt.close();
		//关闭连接数据库的接口
		conn.close();
		return pstmt.executeUpdate();*/
		//1.准备输出数据的接口
		PreparedStatement pstmt;
		int i=0;
		try {
			//准备输出数据
			pstmt=conn.prepareStatement(sql);
			//真正执行输出
			i=pstmt.executeUpdate();
			System.out.println("delete resutl: " + i);
			//关闭输出数据的接口
			pstmt.close();
			//关闭连接数据库的接口
			conn.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	}
