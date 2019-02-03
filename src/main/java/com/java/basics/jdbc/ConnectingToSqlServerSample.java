package com.java.basics.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectingToSqlServerSample {

    public static final String QUIT = "quit";

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
        try (Scanner scanner = new Scanner(System.in);
             Connection conn = DriverManager.getConnection(
                     "jdbc:sqlserver://DESKTOP-QLKEH1D;databaseName=" + databaseName + ";integratedSecurity=true;",
                     "", "");
             Statement stm = conn.createStatement()) {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String statement;
            int rowCount;
            System.out.println("Connected to database: " + databaseName);
            System.out.print("Write a command like\n\tSELECT * FROM Employee\n");
            System.out.printf("Write %s to quit\n\n", QUIT);
            while (true) {
                System.out.print("> ");
                statement = scanner.nextLine();
                if (statement.equalsIgnoreCase(QUIT)) {
                    break;
                }
                System.out.println();
                try {
                    if (statement.trim().substring(0, 6).equalsIgnoreCase("select")) {
                        try (ResultSet result = stm.executeQuery(statement)) {
                           ResultSetHelper.printResultData(result);
                        }
                    } else {
                        rowCount = stm.executeUpdate(statement);
                        System.out.println(rowCount + " rows effected.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error " + e.getMessage() + "\nCode: " + e.getErrorCode());
                }
                System.out.println();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
