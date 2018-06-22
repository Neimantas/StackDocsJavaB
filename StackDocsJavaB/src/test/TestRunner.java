import Models.DBQueryModel;
import Models.DTO.DocTagsDTO;
import Services.DropDown;
import Services.IDataBase;
import Services.IHigherService;
import Services.Impl.DataBase;
import Services.Impl.HigherService;
import Services.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public void AssertAll() throws SQLException {
//        System.out.println(AssertDbConnection());
//        System.out.println(AssertDocTagsCollection());
//        System.out.println(AssertDocTagsIds());
//        System.out.println(AssertDocTagsIds2());
        System.out.println(AssertDocTagsIds3());
        System.out.println(AssertDropDownCollection());
        System.out.println(AssertQueryBuilder());
    }

    private boolean AssertDbConnection() throws SQLException {
        IDataBase db = new DataBase();
        return db.getConnection() != null;
    }

    private boolean AssertDocTagsCollection() {
        IHigherService higher = new HigherService();
        DocTagsDTO dto = higher.getAllDocTags();
        if (dto.getData().size() > 0) return true;

        return false;
    }

    private boolean AssertDocTagsIds() {
        int[] ids = {3, 4, 5, 8};
        int counter = 0;
        IHigherService higher = new HigherService();
        DocTagsDTO dto = higher.getAllDocTags();
        for (int i = 0; i < dto.getData().size(); i++) {
            for (int j = 0; j < ids.length; j++) {
                if (dto.getData().get(i).getId() == ids[j]) {
//                    System.out.println("id: " + dto.getData().get(i).getId() + ", tag: " + dto.getData().get(i).getTag());
                    counter++;
                }
            }
        }
        if (counter == ids.length) {
            return true;
        }
        return false;
    }

    private boolean AssertDocTagsIds2() {
        int[] ids = {3, 4, 5, 8};
        IHigherService higher = new HigherService();
        List<DocTagsDTO> dtoArr = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            if (higher.getDocTagById("" + ids[i]).getData().get(0) != null) {
                dtoArr.add(higher.getDocTagById("" + ids[i]));
//                System.out.println(dtoArr.get(i).getData().get(0).getId());
            }
        }

        if (dtoArr.size() == ids.length) {
            return true;
        }
        return false;
    }

    private boolean AssertDocTagsIds3() {
        String[] ids = {"3", "4", "5", "8"};
        IHigherService higher = new HigherService();

        if (higher.getDocTagById(ids).getData().size() == ids.length) {
            return true;
        }
        return false;
    }

    private boolean AssertDropDownCollection() {

        DropDown dropDown = new DropDown();

//        System.out.println(dropDown.getList().size());
//        System.out.println(dropDown.getSize());
        if (dropDown.getList().size() == dropDown.getSize() && dropDown.getList().get(0) instanceof DocTag) {
            return true;
        }
        return false;
    }

    private boolean AssertQueryBuilder(){
        QueryBuilder qb = new QueryBuilder();
        DBQueryModel queryModel = new DBQueryModel();
        queryModel.table = "topics";
        queryModel.where = "id";
        queryModel.whereValue = new String[] {"10", "14", "18"};
        qb.buildQuery(queryModel);
        String expected = "SELECT * FROM topics WHERE 1 = 1 AND id IN ('10','14','18')";
        System.out.println(qb.getQuery());
        System.out.println(expected);
        return qb.getQuery().equals(expected);
    }

}