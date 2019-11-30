package com.daralisdan.jdbc;

import java.sql.SQLException;

public class JdbcSql_main {

	public static void main(String[] args){
		/**
		 * 查询
		 * 几种调用的写法
		 */
		//1.
		new JdbcSql_select().select();
/*	2.
 * 	try {
			JdbcSql_select.class.newInstance().select();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}*/
/*	3.	
 * try {
			((JdbcSql_select) Class.forName("com.daralisdan.jdbc.JdbcSql_select").newInstance()).select();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
		/*
		 * 4.
		Method select;
		try {
			select = JdbcSql_select.class.getMethod("select", null);
			select.invoke(new JdbcSql_select(), null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/
		
		/**
		 * 增加
		 */
		new JdbcSql_insert().insert(new JdbcSql_user("8","sdy","male","2"));
	    /**
	     * 修改
	     */
		 new JdbcSql_update().update(new JdbcSql_user(" ","Bean", " ", "15")); 
		/**
		 * 删除
		 */
		  try {
			new JdbcSql_delete().delete("Jonly");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 // 第二种：new JdbcSql_delete().delete("sdy");
	}

}
