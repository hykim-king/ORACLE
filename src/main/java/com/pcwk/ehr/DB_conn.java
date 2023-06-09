// DB_conn.java
package com.pcwk.ehr.elcaro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_conn {
    private String jdbcUrl;
    private String username;
    private String password;
    private Connection connection;

    public DB_conn(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println ("DB 연결 성공");
        } catch (SQLException e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("DB 연결 종료");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    
}
