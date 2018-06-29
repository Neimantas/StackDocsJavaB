package Services.Impl;

import Models.DBQueryModel;
import Models.DTO.DBqueryDTO;
import Services.IDataBase;
import Services.ICrud;
import Services.QueryBuilder;

import java.lang.reflect.Field;
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

    public Crud(){
        db = new DataBase();
    }

    @Override
    public DBqueryDTO create(DBQueryModel create) {
        DBqueryDTO dto;
        try {
            connection = db.getConnection();
            String query = "INSERT INTO " + create.getTable() + " VALUES(" + create.getCreateValues() + ")";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            dto = new DBqueryDTO(true, null, null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dto = new DBqueryDTO(false, e.getMessage(), null);
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
    public <T> DBqueryDTO<T> read(DBQueryModel dbQuery, Class<T> type) {
        DBqueryDTO<T> dto;
        try {
            QueryBuilder qb = new QueryBuilder();
            qb.buildQuery(dbQuery);
            connection = db.getConnection();
            statement = connection.createStatement();
            ResultSet rs  = statement.executeQuery(qb.getQuery());
//            int colCount = rs.getMetaData().getColumnCount();
//            List<List<Object>> rows = new ArrayList<>();
//            while (rs.next()) {
//                List<Object> columns = new ArrayList<>();
//                for (int i = 1; i <= colCount; i++) {
//                    columns.add(rs.getObject(i));
//                }
//                rows.add(columns);
//            }
            List<T> rows = new ArrayList<>();
            while (rs.next()) {
                T dal = type.newInstance();
                loadResultSetIntoObject(rs, dal);
                rows.add(dal);
            }
            dto = new DBqueryDTO<>(true, null, rows);
        } catch (SQLException | InstantiationException | IllegalArgumentException | IllegalAccessException e) {
            System.out.println(e.getMessage());
            dto = new DBqueryDTO(false, e.getMessage(), null);
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
        DBqueryDTO dto;
        try {
            String query = "UPDATE " + update.getTable() + " SET '" + update.getUpdateWhat() + "' = '"
                            + update.getUpdateValue() + "' WHERE " + update.getWhere() + " = " + update.getWhereValue().toString();
//            String query = "";
            connection = db.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            dto = new DBqueryDTO(true, null, null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dto = new DBqueryDTO(false, e.getMessage(), null);
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
        DBqueryDTO dto;
        try {
//            String query = "DELETE FROM " + delete.getTable() + " WHERE " + delete.getWhere() +  " = " +
//                            delete.getWhereValue() + " LIMIT 1";
            String query = "";
            connection = db.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            dto = new DBqueryDTO(true, null, null);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dto = new DBqueryDTO(false, e.getMessage(), null);
        } finally {
            try {
                db.closeConnection();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return dto;
    }

    private static void loadResultSetIntoObject(ResultSet rst, Object object)
            throws IllegalArgumentException, IllegalAccessException, SQLException
    {
        Class<?> zclass = object.getClass();
        for(Field field : zclass.getDeclaredFields()) {
            String name = field.getName();
            field.setAccessible(true);
            Object value = rst.getObject(name);
            Class<?> type = field.getType();
            if (isPrimitive(type)) {
                Class<?> boxed = boxPrimitiveClass(type);
                if (type == boolean.class) {
                    value = (int) value == 1;
                } else {
                    value = boxed.cast(value);
                }
            }
            field.set(object, value);
        }
    }

    private static boolean isPrimitive(Class<?> type)
    {
        return (type == int.class || type == long.class ||
                type == double.class  || type == float.class
                || type == boolean.class || type == byte.class
                || type == char.class || type == short.class);
    }

    private static Class<?> boxPrimitiveClass(Class<?> type)
    {
        if (type == int.class){return Integer.class;}
        else if (type == long.class){return Long.class;}
        else if (type == double.class){return Double.class;}
        else if (type == float.class){return Float.class;}
        else if (type == boolean.class){return Boolean.class;}
        else if (type == byte.class){return Byte.class;}
        else if (type == char.class){return Character.class;}
        else if (type == short.class){return Short.class;}
        else
        {
            String string = "Class '" + type.getName() + "' is not a primitive";
            throw new IllegalArgumentException(string);
        }
    }
}
