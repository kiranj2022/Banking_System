package noint;

import java.sql.*;

public class DBConn {
	Connection con;
	Statement st;
	public DBConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_one","root","tiger");
			st=con.createStatement();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
