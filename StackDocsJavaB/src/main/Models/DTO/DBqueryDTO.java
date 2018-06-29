package Models.DTO;

import java.util.List;

public class DBqueryDTO<T> {
    private boolean Success;
    private String Message;
    private List<T> List;

    public DBqueryDTO(boolean success, String message, List<T> list){
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

    public java.util.List<T> getList() {
        return List;
    }

    public void setList(java.util.List<T> list) {
        List = list;
    }
}
