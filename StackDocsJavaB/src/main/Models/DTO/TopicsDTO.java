package Models.DTO;

import Models.DAL.TopicsDAL;

import java.util.List;

public class TopicsDTO {
    private boolean Success;
    private String Message;
    private List<TopicsDAL> data;

    public List<TopicsDAL> getData() {
        return data;
    }

    public void setData(List<TopicsDAL> data) {
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
