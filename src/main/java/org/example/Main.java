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
        stmt.execute("DROP TABLE MY_USER");
        stmt.execute("CREATE TABLE MY_USER(ID VARCHAR(10) PRIMARY KEY, NAME VARCHAR(100))");
        stmt.execute("INSERT INTO MY_USER VALUES ('001', 'ABC')");
        stmt.execute("INSERT INTO MY_USER VALUES ('002', '123')");
        stmt.execute("INSERT INTO MY_USER VALUES ('003', '一二三')");

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