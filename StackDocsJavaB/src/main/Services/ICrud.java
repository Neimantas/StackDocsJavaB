package main.Services;

import main.Models.DBupdateModel;
import main.Models.DTO.DBqueryDTO;

public interface ICrud {
    public DBqueryDTO create(String table, String values);
    public DBqueryDTO read(String table);
    public DBqueryDTO update(DBupdateModel update);
    public DBqueryDTO delete(String table, String id);
}
