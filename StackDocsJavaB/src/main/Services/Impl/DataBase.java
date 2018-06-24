package Services.Impl;

import Services.IDataBase;
import org.omg.CosNaming.NamingContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase implements IDataBase {
    private Connection connection;

    @Override
    public Connection getConnection() throws SQLException {
//        try {
//            System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
//                    "org.apache.naming.java.javaURLContextFactory");
//            Class.forName("org.sqlite.JDBC");
//            Context initContext = new InitialContext();
//            Context envContext  = (Context) initContext.lookup("java:comp/env");
//            DataSource ds = (DataSource)envContext.lookup("jdbc/mydb.sqlite");
//            connection = ds.getConnection();
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (NamingException e) {
//            System.out.println(e.getMessage());
//        }
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
