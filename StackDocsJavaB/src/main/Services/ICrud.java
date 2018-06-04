package main.Services;

import main.Models.DBupdateModel;
import main.Models.DTO.DBqueryDTO;

import java.sql.Connection;

public interface ICrud {
    DBqueryDTO create(String table, String values);
    DBqueryDTO read(String table, Connection connection);
    DBqueryDTO update(DBupdateModel update);
    DBqueryDTO delete(String table, String id);
}
