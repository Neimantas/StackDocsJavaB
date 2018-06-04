package test;

import main.Models.DBupdateModel;
import main.Models.DTO.DBqueryDTO;
import main.Services.ICrud;
import main.Services.IDataBase;
import main.Services.Impl.Crud;
import main.Services.Impl.DataBase;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Testing {
    private static IDataBase db;
    private static Connection connection;

    public static void main(String[] args) throws Throwable {

        ICrud crud = new Crud();
        DBqueryDTO dto = new DBqueryDTO();
        db = new DataBase();
        connection = db.getConnection();
//        DBupdateModel update = new DBupdateModel();
//        update.setTable("person");
//        update.setUpValue("Blorg");
//        update.setUpWhat("name");
//        update.setUpWhere("id");
//        update.setUpWhereValue("3");
        crud.create("person", "8, 'test'");
//        dto = crud.create("person", "4, 'Johny'");
//        dto = crud.create("person", "2, 'yui'");
        dto = crud.read("person", connection);
        ResultSet rs = dto.getData();


        System.out.println("boop");
        while (rs.next()) {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
        }
        db.closeConnection();
        System.out.println("got here");
    }
}
