package main.Services;

import main.Models.DTO.DBqueryDTO;

public interface ICrud {
    public DBqueryDTO create(String table);
    public DBqueryDTO read(String table);
    public DBqueryDTO update(String table);
    public DBqueryDTO delete(String table);
}
