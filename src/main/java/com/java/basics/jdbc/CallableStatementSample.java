package com.java.basics.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementSample {

	public static void main(String[] args) {
		// First download Ms Sql Server JDBC Drivers from
		// https://www.microsoft.com/en-us/download/details.aspx?id=54670.
		// Extract them to a folder, preferably C:\Program Files\Microsoft JDBC Driver
		// 4.1 For SQL Server. Find the jar file sqljdbc41.jar and x64
		// authentication dll file sqljdbc_auth.dll and copy them to your project
		// folder. Then select the project in Eclipse Package Explorer, right click
		// it and select properties->java build path->libraries-> add external jars and
		// select the jar file. Create a database in SQL Server Express (local db seems
		// to be not supported by JDBC)
		// Right click databases and select new database, give it a name,jdbcsample,
		// and click add. Open Sql Server Configuration Manager, go to Sql Server
		// Network Configuration and enable TCP/IP

		String databaseName = "jdbcsample";

		try (Connection conn = DriverManager.getConnection(
				"jdbc:sqlserver://DESKTOP-QLKEH1D;databaseName=" + databaseName + ";integratedSecurity=true;", "", "");
				CallableStatement callableStatement = conn.prepareCall("EXEC dbo.sel_employeeByColumns ? ")) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Connected to database: " + databaseName + "\n");
			callableStatement.setString(1, "Ahmet");// Index number in CallableStatement starts with 1.

			try (ResultSet result = callableStatement.executeQuery()) {
				ResultSetHelper.printResultData(result);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error " + e.getMessage() + "\nCode: " + e.getErrorCode());
		}
	}

}
