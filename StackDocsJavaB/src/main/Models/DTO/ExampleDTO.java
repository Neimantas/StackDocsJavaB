package Models.DTO;

import Models.DAL.ExampleDAL;

import java.util.List;

public class ExampleDTO {

    public boolean success;
    public String message;
    public List<ExampleDAL> list;

    public ExampleDTO(boolean Success, String Message, List<ExampleDAL> List) {
        success = Success;
        message = Message;
        list = List;
    }
}
