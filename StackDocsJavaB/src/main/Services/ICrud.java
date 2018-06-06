package Services;

import Models.DBupdateModel;
import Models.DTO.DBqueryDTO;

public interface ICrud {
    DBqueryDTO create(String table, String values);
    DBqueryDTO read(String table);
    DBqueryDTO update(DBupdateModel update);
    DBqueryDTO delete(String table, String id);
}
