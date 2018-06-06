package Services.Impl;

import Services.IDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase implements IDataBase {
    private Connection connection;

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        connection = DriverManager.getConnection("jdbc:sqlite:src/main/External/mydb.sqlite.db");
        return connection;
    }

    @Override
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
