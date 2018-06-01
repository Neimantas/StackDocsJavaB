package main.Models;

public class DBupdateModel {
    private String upWhat;
    private String upValue;
    private String upWhere;
    private String upWhereValue;
    private String table;

    public String getUpWhat() {
        return upWhat;
    }

    public void setUpWhat(String upWhat) {
        this.upWhat = upWhat;
    }

    public String getUpValue() {
        return upValue;
    }

    public void setUpValue(String upValue) {
        this.upValue = upValue;
    }

    public String getUpWhere() {
        return upWhere;
    }

    public void setUpWhere(String upWhere) {
        this.upWhere = upWhere;
    }

    public String getUpWhereValue() {
        return upWhereValue;
    }

    public void setUpWhereValue(String upWhereValue) {
        this.upWhereValue = upWhereValue;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }


}
