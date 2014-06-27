package com.liqing.dto;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCService {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Connection connection;

    public JDBCService(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
        connection = getConnection();
    }

    public ResultSet executeSelect(String sql) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String sql) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource.getConnection();
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
