package com.DaltonKing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\dalto\\Documents\\JavaIntelliJMasterClass\\TestDB\\testjava.db");
           // conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                "VALUES('joe', 7651324, 'joe@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    "VALUES('jane', 7651324, 'jane@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    "VALUES('dog', 7658662, 'dog@gmail.com')");
//            statement.execute("UPDATE contacts SET phone=5566789 WHERE name='jane'");
//            statement.execute("DELETE FROM contacts WHERE name='joe'");
            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();
            while(results.next()){
                System.out.println(results.getString("name") + " " +
                                    results.getInt("phone") + " " +
                                    results.getString("email"));
            }
            results.close();

            statement.close();
            conn.close();
        } catch(SQLException e){
            System.out.println("Something went wrong" + e.getMessage());
        }
    }
}
