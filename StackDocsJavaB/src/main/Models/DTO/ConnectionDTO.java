package Models.DTO;

import java.sql.Connection;

public class ConnectionDTO {
    public boolean Success;
    public String Message;
    public Connection Connection;

    public ConnectionDTO(boolean success, String message, java.sql.Connection connection) {
        Success = success;
        Message = message;
        Connection = connection;
    }
}
