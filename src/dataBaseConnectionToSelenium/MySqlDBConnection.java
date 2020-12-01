package dataBaseConnectionToSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlDBConnection {
	static Connection conn;
	static Statement stmt;
	static ResultSet resultSet;

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "password123");
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select * from employee where name='Sarjerao'");
			while (resultSet.next()) {
				System.out.println("Employee Id: " + resultSet.getString("empid"));
				System.out.println("Employee Name: " + resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			stmt.close();
			conn.close();
		}

	}

}
