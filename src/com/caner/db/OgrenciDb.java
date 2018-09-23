package com.caner.db;

import java.sql.*;

public class OgrenciDb {
	Connection connection = null;
	Statement statement = null;

	public Connection getConnection(String dbName) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String userName = "root";
			String password = "";
			String url = "jdbc:MySQL://localhost/"+dbName+"?serverTimezone=GMT&useSSL=false";
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("\nbaglandi");
		} catch (Exception ex) {
			System.err.println("Cannot connect to database server");
			ex.printStackTrace();
		}
		return connection;
	}

	public String getSelectTableRows(Connection con, String sqlCommand, int rowIndex) throws SQLException {
		statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(sqlCommand);
		String temp = ""; // kolon kayýtlarýný tutup doldurma
		int count = 1;

		ResultSetMetaData rsmd = resultSet.getMetaData();
		int columnsNumber = rsmd.getColumnCount();

		while (resultSet.next()) {
			if (count == rowIndex) {
				for (int i = 1; i <= columnsNumber; i++)

					temp += resultSet.getString(i) + "\t";
				temp += "\n";
			}
			count++;
		}
		return temp;
	}

	public boolean setInsertUpdateDelete(Connection con, String sqlCommand) {
		try {
			statement = con.createStatement();
			int durum = statement.executeUpdate(sqlCommand);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}	
}
