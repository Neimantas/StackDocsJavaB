package Models.DTO;

import Models.DAL.DocTagsDAL;

import java.util.List;

public class DocTagsDTO {
    public boolean success;
    public String message;
    public List<DocTagsDAL> data;

    public DocTagsDTO(boolean _success, String msg, List<DocTagsDAL> list){
        success = _success;
        message = msg;
        data = list;
    }
}
