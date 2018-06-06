package Models.DTO;

import Models.DAL.ExampleDAL;

import java.util.List;

public class ExampleDTO {

    private boolean Success;
    private String Message;
    private List<ExampleDAL> data;

    public List<ExampleDAL> getData() {
        return data;
    }

    public void setData(List<ExampleDAL> data) {
        this.data = data;
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


}
