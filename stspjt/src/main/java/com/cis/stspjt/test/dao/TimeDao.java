package com.cis.stspjt.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;

@Repository
public class TimeDao {
	@Autowired
	DataSource dataSource;
	
	
	
	public String getTime() throws Exception{
		
		Connection con= dataSource.getConnection();
		PreparedStatement pstmt= (PreparedStatement) con.prepareStatement("select now()");
		
		
		
		
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		return rs.getString(1);
		
		
	}
	
}
