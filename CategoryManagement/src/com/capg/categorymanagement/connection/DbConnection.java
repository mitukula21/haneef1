package com.capg.categorymanagement.connection;

import java.sql.*;

public class DbConnection
{
	public Connection getConnection() throws ClassNotFoundException
	{
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");   
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
			System.out.println("connected.....");
		
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}