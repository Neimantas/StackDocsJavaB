package Services;

import Models.DBQueryModel;
import Models.DTO.DBqueryDTO;

public interface ICrud {
    DBqueryDTO create(String table, String values);
    DBqueryDTO read(DBQueryModel dbQuery);
    DBqueryDTO update(DBQueryModel update);
    DBqueryDTO delete(String table, String id);
}
