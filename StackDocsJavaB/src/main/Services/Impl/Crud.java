package main.Services.Impl;

import main.Models.DTO.DBqueryDTO;
import main.Services.ICrud;
import main.Services.IDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud implements ICrud {

    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    private IDataBase db;
    private DBqueryDTO dto;

    public Crud(){
        db = new DataBase();
    }

    @Override
    public DBqueryDTO create(String table) {
        try {
            dto = new DBqueryDTO();
            connection = db.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(table);
            dto.setSuccess(true);
        } catch (SQLException e) {
            dto.setSuccess(false);
            dto.setMessage(e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            try {
                db.closeConnection();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return dto;
    }

    @Override
    public DBqueryDTO read(String table) {
        try {
            dto = new DBqueryDTO();
            connection = db.getConnection();
            statement = connection.createStatement();
            dto.setData(statement.executeQuery(table));
            dto.setSuccess(true);
        } catch (SQLException e) {
            dto.setSuccess(false);
            dto.setMessage(e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            try {
                db.closeConnection();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return dto;
    }

    @Override
    public DBqueryDTO update(String table) {
        return create(table);
    }

    @Override
    public DBqueryDTO delete(String table) {
        return create(table);
    }
}
