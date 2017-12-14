package com.cis.stspjt.test.junittest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.Statement;



public class DB_Test {
	@Test
	public void Test() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con =     DriverManager.getConnection("jdbc:mysql://52.198.48.117:43306/TEST_DB?useSSL=true&verifyServerCertificate=false","testuser","testuser1234"); 
	    System.out.println(con);
	    
		Statement stmt =null;
		stmt = (Statement) con.createStatement();
		
		
		
		
		ResultSet rs = stmt.executeQuery("select user_name from t_cmt_user");
		rs.next();
		System.out.println(rs.getString(1));
		rs.close();
		stmt.close();
		con.close();
		
		
	}

}
