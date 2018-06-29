package Models.DTO;

import Models.DAL.DocTagsDAL;

import java.util.List;

public class DocTagsDTO {
    private boolean Success;
    private String Message;
    private List<DocTagsDAL> List;

    public DocTagsDTO(boolean success, String message, List<DocTagsDAL> list){
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

    public java.util.List<DocTagsDAL> getList() {
        return List;
    }

    public void setList(java.util.List<DocTagsDAL> list) {
        List = list;
    }
}
