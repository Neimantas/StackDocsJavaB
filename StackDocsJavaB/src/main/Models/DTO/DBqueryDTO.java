package Models.DTO;

import java.util.List;

public class DBqueryDTO<T> {
    public boolean success;
    public String message;
    public List<T> data;

    public DBqueryDTO(boolean _success, String msg, List<T> list){
        success = _success;
        message = msg;
        data = list;
    }
}
