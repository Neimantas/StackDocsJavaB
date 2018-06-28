package Models.DTO;

import Models.DAL.ExampleDAL;

import java.util.List;

public class ExampleDTO {

    public boolean success;
    public String message;
    public List<ExampleDAL> data;

    public ExampleDTO(boolean _success, String msg, List<ExampleDAL> list){
        success = _success;
        message = msg;
        data = list;
    }
}
