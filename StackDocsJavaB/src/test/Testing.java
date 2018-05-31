package test;

import main.Models.DTO.DBqueryDTO;
import main.Services.ICrud;
import main.Services.IDataBase;
import main.Services.Impl.Crud;


import java.sql.Connection;
import java.sql.ResultSet;

public class Testing {
    private static IDataBase db;
    private static Connection connection;

    public static void main(String[] args) throws Throwable {

        ICrud crud = new Crud();
        DBqueryDTO dto;

        dto = crud.create("create table person (id integer, name string)");
        System.out.println(dto.isSuccess());
        System.out.println(dto.getMessage());
        dto = crud.update("insert into person values(1, 'leo')");
        dto = crud.update("insert into person values(2, 'yui')");
        ResultSet rs = crud.read("select * from person").getData();
//        db = new DataBase();
//        connection = db.getConnection();
//
//        Statement statement = connection.createStatement();
//        String query = "CREATE DATABASE STUDENTS";
//        statement.executeUpdate("drop table if exists person");
//        statement.executeUpdate("create table person (id integer, name string)");
//        statement.executeUpdate("insert into person values(1, 'leo')");
//        statement.executeUpdate("insert into person values(2, 'yui')");
//        int b = statement.executeUpdate("drop table if exists person");
//        int c = statement.executeUpdate("drop table if exists person");
//        ResultSet rs = statement.executeQuery("select * from person");
//        try {
//            boolean a = statement.execute("select * from nowhere");
//            System.out.println(a);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println("boop");
        while (rs.next()) {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
        }
        System.out.println("got here");
    }
}
