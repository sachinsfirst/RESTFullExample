package com.mkyong.rest.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class TestDbConn {

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties properties = new Properties();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/visitordb", "root", "wr6BReGU@");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Visitor");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
						+ rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
