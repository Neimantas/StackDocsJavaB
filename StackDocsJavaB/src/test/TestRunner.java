import Models.BusinessLogic.DocTag;
import Models.BusinessLogic.Topic;
import Models.DBQueryModel;
import Models.DTO.DBqueryDTO;
import Models.DTO.DocTagsDTO;
import Services.IDataBase;
import Services.IHigherService;
import Services.Impl.Cache;
import Services.Impl.Crud;
import Services.Impl.DataBase;
import Services.Impl.HigherService;
import Services.Pagination;

import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public void AssertAll() throws SQLException {
        System.out.println(AssertDbConnection());
        System.out.println(AssertDocTagsCollection());
        System.out.println(AssertDocTagsIds());
        System.out.println(AssertDocTagsIds2());
        System.out.println(AssertDocTagsIds3());
        System.out.println(AssertTenTopicsById());
        System.out.println(AssertDropDownCollection());
        System.out.println(CheckCache());
        System.out.println(CheckCache2());
        System.out.println("Pagination: " + AssertListFromPagination());
        System.out.println("Crud: " + AssertTenTopicsFromDataBase());
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

    private boolean AssertTenTopicsById() {

        IHigherService higher = new HigherService();

        if (higher.getTenTopicsById(true, "3").getData().size() == 10) {
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

    private boolean CheckCache() {
        Cache cache = Cache.getInstance();
        DocTag docTag = new DocTag();
        docTag.setId(1);
        cache.put("test", docTag);
        DocTag newDocTag = (DocTag)cache.get("test");
        if (newDocTag.getId() == docTag.getId()) {
            return true;
        }
        return false;
    }
    private boolean CheckCache2() {
        Cache cache = Cache.getInstance();
        List<DocTag> list = new ArrayList<>();
        DocTag docTag = new DocTag();
        docTag.setId(1);
        list.add(docTag);
        cache.put("test", list);
        AbstractList newList = (AbstractList)cache.get("test");
        List<DocTag> newest = new ArrayList<>();
        for (Object item: newList) {
            newest.add((DocTag) item);
        }
        DocTag newDocTag = (DocTag) newList.get(0);
        if (newDocTag.getId() == docTag.getId() && newest.get(0).getId() == docTag.getId())  {
            return true;
        }
        return false;
    }

    private boolean AssertListFromPagination() {
        Pagination pg = new Pagination();
        List<Topic> list = pg.getList(null, "5", "Installingasjgdfklasbgjnglakg", true);
        for (Topic item : list) {
            System.out.println("testinam test: title - " + item.getTitle() + ", id - " + item.getId());
        }
        if (pg.getList(null, "5", "Installing", true).size() == 10) {
            return true;
        }
        return false;
    }

    private boolean AssertTenTopicsFromDataBase() {
        Crud cd = new Crud();
        DBQueryModel query = new DBQueryModel();
        query.table = "Topics";
        query.where = "id";
        query.whereValue = new String[] {"1", "2", "3", "4", "5", "6", "8", "10", "11", "12"};
        DBqueryDTO dto = cd.read(query);

        return false;
    }
}