package main.Services;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDataBase {
    public Connection getConnection() throws SQLException;
    public void closeConnection() throws SQLException;
}
