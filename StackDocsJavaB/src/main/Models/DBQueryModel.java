package Models;

public class DBQueryModel {
    private String Table;
    private String Where;
    private String[] WhereValue;
    private String UpdateWhat;
    private String UpdateValue;
    private int Quantity = 10;
    private boolean Single = false;
    private String CreateValues;
    private boolean After = true;

    public String getTable() {
        return Table;
    }

    public void setTable(String table) {
        Table = table;
    }

    public String getWhere() {
        return Where;
    }

    public void setWhere(String where) {
        Where = where;
    }

    public String[] getWhereValue() {
        return WhereValue;
    }

    public void setWhereValue(String[] whereValue) {
        WhereValue = whereValue;
    }

    public String getUpdateWhat() {
        return UpdateWhat;
    }

    public void setUpdateWhat(String updateWhat) {
        UpdateWhat = updateWhat;
    }

    public String getUpdateValue() {
        return UpdateValue;
    }

    public void setUpdateValue(String updateValue) {
        UpdateValue = updateValue;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public boolean isSingle() {
        return Single;
    }

    public void setSingle(boolean single) {
        Single = single;
    }

    public String getCreateValues() {
        return CreateValues;
    }

    public void setCreateValues(String createValues) {
        CreateValues = createValues;
    }

    public boolean isAfter() {
        return After;
    }

    public void setAfter(boolean after) {
        After = after;
    }
}
