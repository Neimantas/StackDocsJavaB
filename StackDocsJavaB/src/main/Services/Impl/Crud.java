package Services.Impl;

import Models.DBQueryModel;
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
    public DBqueryDTO create(DBQueryModel create) {
        try {
            dto = new DBqueryDTO();
            connection = db.getConnection();
            String query = "INSERT INTO " + create.getTable() + " VALUES(" + create.getCreateValues() + ")";
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
    public DBqueryDTO read(DBQueryModel dbQuery) {
        try {
            String query = "";
            if (dbQuery.getWhere() == null) {
                query = "SELECT * FROM " + dbQuery.getTable();
            } else if (dbQuery.isSingle()) {
                query = "SELECT * FROM " + dbQuery.getTable() + " WHERE " + dbQuery.getWhere() + " = " +
                        dbQuery.getWhereValue();
            } else {
                query = "SELECT * FROM " + dbQuery.getTable() + " WHERE " + dbQuery.getWhere() + " >= " +
                        dbQuery.getWhereValue() + " LIMIT " + dbQuery.getQuantity();
            }
            dto = new DBqueryDTO();
            connection = db.getConnection();
            statement = connection.createStatement();
            ResultSet rs  = statement.executeQuery(query);
            int colCount = rs.getMetaData().getColumnCount();
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
    public DBqueryDTO update(DBQueryModel update) {
        try {
            String query = "UPDATE " + update.getTable() + " SET '" + update.getUpdateWhat() + "' = '"
                            + update.getUpdateValue() + "' WHERE " + update.getWhere() + " = " + update.getWhereValue();
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
    public DBqueryDTO delete(DBQueryModel delete) {
        try {
            String query = "DELETE FROM " + delete.getTable() + " WHERE " + delete.getWhere() +  " = " +
                            delete.getWhereValue() + " LIMIT 1";
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
