package Models.DTO;

import Models.DAL.ExampleDAL;

import java.util.List;

public class ExampleDTO {

    private boolean Success;
    private String Message;
    private List<ExampleDAL> List;

    public ExampleDTO(boolean success, String message, List<ExampleDAL> list){
        Success = success;
        Message = message;
        List = list;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public java.util.List<ExampleDAL> getList() {
        return List;
    }

    public void setList(java.util.List<ExampleDAL> list) {
        List = list;
    }
}
