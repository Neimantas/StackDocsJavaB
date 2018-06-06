package Services.Impl;

import Models.DBupdateModel;
import Models.DTO.DBqueryDTO;
import Services.IDataBase;
import Services.ICrud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            dto = new DBqueryDTO();
            connection = db.getConnection();
            String query = "INSERT INTO " + table + " VALUES(" + values + ")";
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
    public DBqueryDTO read(String table) {
        try {
            dto = new DBqueryDTO();
            connection = db.getConnection();
            String query = "SELECT * FROM " + table;
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            int colCount= rs.getMetaData().getColumnCount();
            List<List<Object>> rows = new ArrayList<>();
            while (rs.next()) {
                List<Object> columns = new ArrayList<>();
                for (int i = 1; i <= colCount; i++) {
                    columns.add(rs.getObject(i));
                }
                rows.add(columns);
            }
            dto.setData(rows);
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
    public DBqueryDTO update(DBupdateModel update) {
        try {
            String query = "UPDATE " + update.getTable() + " SET '" + update.getUpWhat() + "' = '"
                            + update.getUpValue() + "' WHERE " + update.getUpWhere() + " = " + update.getUpWhereValue();
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
            String query = "DELETE FROM " + table + " WHERE id = " + id;
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
