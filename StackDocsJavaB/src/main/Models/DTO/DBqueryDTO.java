package Models.DTO;

import java.util.List;
import java.util.List;

public class DBqueryDTO {
    private boolean success;
    private String message;
    private List<List<Object>> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<List<Object>> getData() {
        return data;
    }

    public void setData(List<List<Object>> data) {
        this.data = data;
    }


}
