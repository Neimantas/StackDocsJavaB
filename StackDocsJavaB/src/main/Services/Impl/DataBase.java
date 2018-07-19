package Services.Impl;

import Models.DTO.ConnectionDTO;
import Services.IDataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase implements IDataBase {
    private Connection connection;

    @Override
    public ConnectionDTO getConnection(){
        try {
            String url = "jdbc:sqlite:mydb.sqlite.db";
            Class.forName("org.sqlite.JDBC").newInstance();
            connection = DriverManager.getConnection(url);
            return new ConnectionDTO(true, "", connection);
        } catch (Exception e){
            return new ConnectionDTO(false, e.getMessage(), null);
        }
    }

    @Override
    public ConnectionDTO closeConnection(){
        if (connection != null) {
            try{
                connection.close();
                return new ConnectionDTO(true, "", null);
            } catch (Exception e) {
                // TODO same as below
                return new ConnectionDTO(false, "ERROR: failed to close the DB connection.", connection);
            }
        } else {
            //TODO use the error enum class here
            return new ConnectionDTO(false, "ERROR: Nothing to close", null);
        }
    }
}
