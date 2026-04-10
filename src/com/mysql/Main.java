/**
 *  Java program to demonstrate java JDBC connectivity.
 */

package com.mysql;

import java.sql.*;

/**
 *  Main class.
 */
public class Main {

    // JVM entry point.
    public static void main(String[] args) throws SQLException {

        // Getting all users.
        demoMethodSelect(); // Output: Jack
                            // Bernard
                            // Jack
                            //Kate

        // Getting users with name Jack.
        demoMethodSelectWithCondition("Jack"); // Output: id = 1; name = Jack
                                                     // id = 3; name = Jack

    }

    // Method to connect to SQL server and show all users.
    public static void demoMethodSelect() throws SQLException {
        String sql = "SELECT * FROM users";

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db",
                "root", "toortoor");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // Printing the results.
        while (resultSet.next()) {
            System.out.println(resultSet.getString("user_name"));
        }

        // Closing resources.
        resultSet.close();
        statement.close();
        connection.close();

    }

    // Method to connect to SQL server and show users with some name.
    public static void demoMethodSelectWithCondition(String input) throws SQLException {
        String sql = "SELECT id, user_name FROM users WHERE users.user_name = '" + input + "'";

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db",
                "root", "toortoor");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // Printing the results.
        while (resultSet.next()) {
            System.out.println("id = " + resultSet.getInt("id") + "; name = " + resultSet.getString("user_name"));
        }

        // Closing resources.
        resultSet.close();
        statement.close();
        connection.close();

    }
}