

import Models.BusinessLogic.DocTag;
import Models.DAL.DocTagsDAL;
import Models.DTO.DBqueryDTO;
import Models.DTO.DocTagsDTO;
import Services.ICrud;
import Services.IDataBase;
import Services.IHigherService;
import Services.Impl.Crud;
import Services.Impl.HigherService;

import java.sql.Connection;
import java.util.List;


public class Testing {
    private static IDataBase db;
    private static Connection connection;

    public static void main(String[] args) throws Throwable {

//        ICrud crud = new Crud();
//        DBqueryDTO dto;
        IHigherService higher = new HigherService();
        DocTagsDTO dto = higher.getAllDocTags();
        DocTagsDAL dal = dto.getData().get(0);
        DocTag docTag = new DocTag();
//        docTag.id = dal.getId();
//        docTag.tag = dal.getTag();
//        docTag.title = dal.getTitle();
//        System.out.println(docTag.id);
//        System.out.println(docTag.title);
//        db = new DataBase();
//        connection = db.getConnection();
//        DBupdateModel update = new DBupdateModel();
//        update.setTable("person");
//        update.setUpValue("Blorg");
//        update.setUpWhat("name");
//        update.setUpWhere("id");
//        update.setUpWhereValue("3");
//        crud.create("person", "10, 'test'");
//        dto = crud.create("person", "4, 'Johny'");
//        dto = crud.create("person", "2, 'yui'");
//        dto = crud.read("person");
//        List<List<Object>> rows = dto.getData();
//        for(int i = 0; i < rows.size(); i++) {
//            List<Object> columns = rows.get(i);
//            System.out.println((int) columns.get(0));
//            System.out.println((String) columns.get(1));
//        }
    }
}
