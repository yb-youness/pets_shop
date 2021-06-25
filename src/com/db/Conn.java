package com.db;


import java.sql.Connection;
import java.sql.SQLException;





import com.mysql.cj.jdbc.MysqlDataSource;

public class Conn  {
	// Get The  Props From The Config File 
	private static String Jdbc_UrL ="jdbc:mysql://localhost:3306/petshopdb";
	private static String User_Name ="root";
	private static String Pass ="";
	//private static String Driver ="com.mysql.cj.jdbc.Driver";
	private static  MysqlDataSource dataSource;
	public static Connection getConnection() {
		Connection con = null;
		try {
			
			dataSource=new MysqlDataSource();
			dataSource.setUrl(Jdbc_UrL);
			dataSource.setUser(User_Name);
			dataSource.setPassword(Pass);
			con= dataSource.getConnection();
		} catch ( SQLException  e) {
			e.printStackTrace();
		}
		return con;
	}


}
	
  
	



	
	
	
	
	
	
	
	
	
	

