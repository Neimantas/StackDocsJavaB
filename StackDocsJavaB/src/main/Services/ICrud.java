package main.Services;

import main.Models.DBupdateModel;
import main.Models.DTO.DBqueryDTO;

import java.sql.Connection;

public interface ICrud {
    public DBqueryDTO create(String table, String values);
    public DBqueryDTO read(String table, Connection connection);
    public DBqueryDTO update(DBupdateModel update);
    public DBqueryDTO delete(String table, String id);
}
