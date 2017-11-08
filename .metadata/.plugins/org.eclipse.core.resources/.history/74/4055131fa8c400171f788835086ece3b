package com.cms.core.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		//sessionVariables = FOREIGN_KEY_CHECK=0 means ignore forign key relevance
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cms?sessionVariables=FOREIGN_KEY_CHECKS=0", 
				"root", "326990");
		return con;
	}
	
	public static void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ps) {
		try {
			if(ps!=null) ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
