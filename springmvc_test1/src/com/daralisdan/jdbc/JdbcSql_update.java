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
public class JdbcSql_update {
//一个私有的静态的方法
	public static int update(JdbcSql_user user) {
		//创建一个与数据库连接的接口，连接数据库
		
		Connection conn=JdbcSql_Connection.getConn();
		
		//输出数据的条件，，，修改
		
		String sql="update user set age='"+user.getAge()+
				"' where name='"+user.getName()+"'";
		
		//准备输出数据的接口
		
		PreparedStatement pstmt;
		int i=0;
		try {
			
			//准备输出数据的接口，输出数据
			
			pstmt=conn.prepareStatement(sql);
			
			//真正执行输出,输出数据
			
			i=pstmt.executeUpdate();
			System.out.println("updaet result:"+i);
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
