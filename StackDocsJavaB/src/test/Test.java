import Models.BL.DocTag;
import Models.BL.Topic;
import Models.DAL.TopicsDAL;
import Models.DBQueryModel;
import Models.DTO.DBqueryDTO;
import Models.DTO.DocTagsDTO;
import Models.URLSettingsModel;
import Services.*;
import Services.Impl.Cache;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Test {

    static IDataBase db;
    static ICrud crud;
    static IHigherService higher;

    @org.junit.BeforeClass
    public static void setup() {
        db = DIContainer.getInjector().getInstance(IDataBase.class);
        crud = DIContainer.getInjector().getInstance(ICrud.class);
        higher = DIContainer.getInjector().getInstance(IHigherService.class);
    }

    @org.junit.Test
    public void DbgetConnection() throws Exception {
        assertTrue(db.getConnection() != null);
    }

    @org.junit.Test
    public void AssertDocTagsCollection() {
        DocTagsDTO dto = higher.getAllDocTags();
        assertTrue((dto.getList().size() > 0));
    }

    @org.junit.Test
    public void AssertDocTagsIds() {
        int[] ids = {3, 4, 5, 8};
        int counter = 0;
        DocTagsDTO dto = higher.getAllDocTags();
        for (int i = 0; i < dto.getList().size(); i++) {
            for (int j = 0; j < ids.length; j++) {
                if (dto.getList().get(i).getId() == ids[j]) {
                    counter++;
                }
            }
        }
        assertTrue((counter == ids.length));
    }

    @org.junit.Test
    public void AssertDocTagsIds2() {
        int[] ids = {3, 4, 5, 8};
        List<DocTagsDTO> dtoArr = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            if (higher.getDocTagById("" + ids[i]).getList().get(0) != null) {
                dtoArr.add(higher.getDocTagById("" + ids[i]));

            }
        }
        assertTrue((dtoArr.size() == ids.length));
    }

    @org.junit.Test
    public void AssertDocTagsIds3() {
        String[] ids = {"3", "4", "5", "8"};
        assertTrue((higher.getDocTagById(ids).getList().size() == ids.length));
    }

    @org.junit.Test
    public void AssertDropDownCollection() {
        DropDown dropDown = new DropDown();
        assertTrue(dropDown.getList().size() == 4);
    }

    @org.junit.Test
    public void CheckCache() {
        Cache cache = Cache.getInstance();
        List<DocTag> list = new ArrayList<>();
        DocTag docTag = new DocTag();
        docTag.setId(1);
        list.add(docTag);
        cache.put("test", list);
        AbstractList newList = (AbstractList) cache.get("test");
        List<DocTag> newest = new ArrayList<>();
        for (Object item : newList) {
            newest.add((DocTag) item);
        }
        DocTag newDocTag = (DocTag) newList.get(0);
        assertTrue(newDocTag.getId() == docTag.getId() && newest.get(0).getId() == docTag.getId());
    }

    @org.junit.Test
    public void AssertListFromPagination() {
        Pagination pg = new Pagination();
        URLSettingsModel model = new URLSettingsModel("5", null, "to", true);
        List<Topic> list = pg.getList(model);
        for (Topic item : list) {
            System.out.println("testinam test: title - " + item.getTitle() + ", id - " + item.getId());
        }
        assertTrue(pg.getList(model).size() == 10);
    }

    @org.junit.Test
    public void AssertTenTopicsFromDataBase() {
        DBQueryModel query = new DBQueryModel();
        query.setTable("Topics");
        query.setWhere("id");
        query.setWhereValue(new String[]{"1", "2", "3", "4", "5", "6", "8", "10", "11", "12"});
        DBqueryDTO dto = crud.read(query, TopicsDAL.class);
        assertTrue(dto != null);
    }
}
