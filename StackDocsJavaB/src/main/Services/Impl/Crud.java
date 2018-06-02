package main.Services.Impl;

import main.Models.DBupdateModel;
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
    private IDataBase db;
    private DBqueryDTO dto;

    public Crud(){
        db = new DataBase();
    }

    @Override
    public DBqueryDTO create(String table, String values) {
        try {
            //TODO Check if table exists, if not create that table first
            String query = "INSERT INTO " + table + " VALUES(" + values + ")";
            dto = new DBqueryDTO();
            connection = db.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
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
    /**
     * Don't forget to close the connection after parsing the ResultSet
     * db.closeConnection();
     */
    @Override
    public DBqueryDTO read(String table, Connection connection) {
        try {
            dto = new DBqueryDTO();
            String query = "SELECT * FROM " + table;
            statement = connection.createStatement();
            dto.setData(statement.executeQuery(query));
            dto.setSuccess(true);
        } catch (SQLException e) {
            dto.setSuccess(false);
            dto.setMessage(e.getMessage());
            System.out.println(e.getMessage());
        }
        return dto;
    }

    @Override
    public DBqueryDTO update(DBupdateModel update) {
        try {
            //TODO Check if table exists, if not create that table first
            String query = "UPDATE " + update.getTable() + " SET " + update.getUpWhat() + " = "
                            + update.getUpValue() + " WHERE " + update.getUpWhere() + " = " + update.getUpWhereValue();
            dto = new DBqueryDTO();
            connection = db.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
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
    public DBqueryDTO delete(String table, String id) {
        try {
            String query = "DELETE FROM " + table + "WHERE id = " + id;
            dto = new DBqueryDTO();
            connection = db.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
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
}
