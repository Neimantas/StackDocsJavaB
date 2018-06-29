import Models.BusinessLogic.DocTag;
import Models.BusinessLogic.Topic;
import Models.DAL.TopicsDAL;
import Models.DBQueryModel;
import Models.DTO.DBqueryDTO;
import Models.DTO.DocTagsDTO;
import Models.URLSettingsModel;
import Services.DropDown;
import Services.IDataBase;
import Services.IHigherService;
import Services.Impl.Cache;
import Services.Impl.Crud;
import Services.Impl.DataBase;
import Services.Impl.HigherService;
import Services.Pagination;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Test {

    @org.junit.Test
    public void DbgetConnection() throws Exception {
        IDataBase db = new DataBase();
        assertTrue(db.getConnection() != null);
    }

    @org.junit.Test
    public void AssertDocTagsCollection() throws Exception{
        IHigherService higher = new HigherService();
        DocTagsDTO dto = higher.getAllDocTags();
        assertTrue((dto.data.size() > 0));
    }

    @org.junit.Test
    public void AssertDocTagsIds() throws Exception{
        int[] ids = {3, 4, 5, 8};
        int counter = 0;
        IHigherService higher = new HigherService();
        DocTagsDTO dto = higher.getAllDocTags();
        for (int i = 0; i < dto.data.size(); i++) {
            for (int j = 0; j < ids.length; j++) {
                if (dto.data.get(i).Id == ids[j]) {
                    counter++;
                }
            }
        }
        assertTrue((counter == ids.length));
    }

    @org.junit.Test
    public void AssertDocTagsIds2() throws Exception{
        int[] ids = {3, 4, 5, 8};
        IHigherService higher = new HigherService();
        List<DocTagsDTO> dtoArr = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            if (higher.getDocTagById("" + ids[i]).data.get(0) != null) {
                dtoArr.add(higher.getDocTagById("" + ids[i]));

            }
        }
        assertTrue((dtoArr.size() == ids.length));
    }

    @org.junit.Test
    public void AssertDocTagsIds3() throws Exception{
        String[] ids = {"3", "4", "5", "8"};
        IHigherService higher = new HigherService();
        assertTrue((higher.getDocTagById(ids).data.size() == ids.length));
    }

    @org.junit.Test
    public void AssertDropDownCollection() throws Exception{
        DropDown dropDown = new DropDown();
        assertTrue(dropDown.getList().size() == 4);
    }

    @org.junit.Test
    public void CheckCache() throws Exception{
        Cache cache = Cache.getInstance();
        List<DocTag> list = new ArrayList<>();
        DocTag docTag = new DocTag();
        docTag.Id = 1;
        list.add(docTag);
        cache.put("test", list);
        AbstractList newList = (AbstractList) cache.get("test");
        List<DocTag> newest = new ArrayList<>();
        for (Object item : newList) {
            newest.add((DocTag) item);
        }
        DocTag newDocTag = (DocTag) newList.get(0);
        assertTrue(newDocTag.Id == docTag.Id && newest.get(0).Id == docTag.Id);
    }

    @org.junit.Test
    public void AssertListFromPagination() throws Exception{
        Pagination pg = new Pagination();
        URLSettingsModel model = new URLSettingsModel();
        model.docTagId = "5";
        model.searchQuery = "to";
        List<Topic> list = pg.getList(model);
        for (Topic item : list) {
            System.out.println("testinam test: title - " + item.Title + ", id - " + item.Id);
        }
        assertTrue(pg.getList(model).size() == 10);
    }

    @org.junit.Test
    public void AssertTenTopicsFromDataBase() {
        Crud cd = new Crud();
        DBQueryModel query = new DBQueryModel();
        query.table = "Topics";
        query.where = "id";
        query.whereValue = new String[]{"1", "2", "3", "4", "5", "6", "8", "10", "11", "12"};
        DBqueryDTO dto = cd.read(query, TopicsDAL.class);
        assertTrue(dto != null);
    }
}
