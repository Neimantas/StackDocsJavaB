package Models.DTO;

import Models.DAL.DocTagsDAL;

import java.util.List;

public class DocTagsDTO {
    private boolean Success;
    private String Message;
    private List<DocTagsDAL> data;

    public List<DocTagsDAL> getData() {
        return data;
    }

    public void setData(List<DocTagsDAL> data) {
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
