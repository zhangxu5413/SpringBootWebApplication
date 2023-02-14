package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author zxcvb
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT NAME FROM MY_USER WHERE ID = '003'");
        while (rs.next()) {
            String name = rs.getString("NAME");
            System.out.println(name);
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}