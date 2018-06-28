package Services;

import Models.DBQueryModel;
import Models.DTO.DBqueryDTO;

public interface ICrud {
    DBqueryDTO create(DBQueryModel create);
    <T> DBqueryDTO<T> read(DBQueryModel dbQuery, Class<T> type);
    DBqueryDTO update(DBQueryModel update);
    DBqueryDTO delete(DBQueryModel delete);
}
