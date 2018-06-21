import Models.DTO.DocTagsDTO;
import Services.IDataBase;
import Services.IHigherService;
import Services.Impl.DataBase;
import Services.Impl.HigherService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public void AssertAll() throws SQLException {
        System.out.println(AssertDbConnection());
        System.out.println(AssertDocTagsCollection());
        System.out.println(AssertDocTagsIds());
        System.out.println(AssertDocTagsIds2());
        System.out.println(AssertDocTagsIds3());
        System.out.println(AssertDropDownCollection());
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
//        DropDown dropDown = new DropDown();
//        if (dropDown.getList().size() == dropDown.getSize()) {
//            return true;
//        }
        return false;
    }
}