package com.daralisdan.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class JdbcSql_select {
//定义一个私有的静态方法
 public Object select() {
		//准备连接数据库的接口，连接数据库
		Connection conn=JdbcSql_Connection.getConn(); 
		//准备输出的数据 条件，，，查询
		String sql="select * from user";
		//准备输出数据的接口
		PreparedStatement pstmt;
		try {
			//准备输出数据
			pstmt=conn.prepareStatement(sql);
			//真正执行输出
		ResultSet rs=pstmt.executeQuery();	
		int col=rs.getMetaData().getColumnCount();
		System.out.println("************");
		while(rs.next()) {
			for (int i = 1; i <=col; i++) {
				System.out.print(rs.getString(i)+"\t");
				if ((i==2) && (rs.getString(i).length()<8)) {
					System.out.println("\t");
				}
			}
			System.out.println(" ");
		}
		System.out.println("************");
		} catch (SQLException e) {
             e.printStackTrace();
		}
	         return null;
	}
	
	
	
}
