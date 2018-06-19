package Models;

public class DBQueryModel {
    private String table;
    private String where;
    private String whereValue;
    private String updateWhat;
    private String updateValue;
    private int quantity = 10;
    private boolean single = false;
    private String createValues;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhereValue() {
        return whereValue;
    }

    public void setWhereValue(String whereValue) {
        this.whereValue = whereValue;
    }

    public String getUpdateWhat() {
        return updateWhat;
    }

    public void setUpdateWhat(String updateWhat) {
        this.updateWhat = updateWhat;
    }

    public String getUpdateValue() {
        return updateValue;
    }

    public void setUpdateValue(String updateValue) {
        this.updateValue = updateValue;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public String getCreateValues() {
        return createValues;
    }

    public void setCreateValues(String createValues) {
        this.createValues = createValues;
    }
}
