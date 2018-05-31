package main.Models.DTO;

import java.sql.ResultSet;

public class DBqueryDTO {
    private boolean success;
    private String message;
    private ResultSet data;

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

    public ResultSet getData() {
        return data;
    }

    public void setData(ResultSet data) {
        this.data = data;
    }
}
