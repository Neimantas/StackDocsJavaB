package Services;

import Models.DBQueryModel;
import Models.DTO.DBqueryDTO;

public interface ICrud {
    DBqueryDTO create(DBQueryModel create);
    DBqueryDTO read(DBQueryModel dbQuery);
    DBqueryDTO update(DBQueryModel update);
    DBqueryDTO delete(DBQueryModel delete);
}
