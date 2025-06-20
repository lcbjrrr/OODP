package org.acme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:helloworld.db";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS messages (" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " message TEXT NOT NULL);";
            stmt.execute(sqlCreateTable);
            String sqlInsert = "INSERT INTO messages (message) VALUES ('Hello, SQLite World!');";
            int rowsAffected = stmt.executeUpdate(sqlInsert);
            ResultSet rs = stmt.executeQuery("SELECT id, message FROM messages;");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + "\tMessage: " + rs.getString("message"));
            }
        }catch(Exception e ){e.printStackTrace();}

    }
}