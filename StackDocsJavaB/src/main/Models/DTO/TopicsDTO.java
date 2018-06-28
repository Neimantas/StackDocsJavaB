package Models.DTO;

import Models.DAL.TopicsDAL;

import java.util.List;

public class TopicsDTO {
    public boolean success;
    public String message;
    public List<TopicsDAL> data;

    public TopicsDTO(boolean _success, String msg, List<TopicsDAL> list){
        success = _success;
        message = msg;
        data = list;
    }
}
