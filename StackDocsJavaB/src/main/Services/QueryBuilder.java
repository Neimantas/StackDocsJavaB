package Services;

import Models.DBQueryModel;

public class QueryBuilder {
    private StringBuilder sb = new StringBuilder();
    private String tableName;


    public void buildQuery(DBQueryModel queryModel) {
        if (queryModel.table != null) {
            resetQuery();
            tableName = queryModel.table;
            sb.append("SELECT * FROM ").append(tableName).append(" WHERE 1 = 1");
        } else if (queryModel.table == null && (tableName == null || tableName.isEmpty())) {
            //TODO what should happen here ???
            System.out.println("You should have given me a table name...");
            return;
        }

        if (queryModel.where != null && queryModel.whereValue != null) {
            whereClause(queryModel);
        }

    }

    public void whereClause(DBQueryModel queryModel) {
        String[] values = queryModel.whereValue;
        sb.append(" AND ").append(queryModel.where).append(" IN (");
        for (int i = 0; i < values.length; i++) {
            sb.append("'").append(values[i]).append("'");
            if (i != values.length - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
    }

    public String getQuery(){
        return sb.toString();
    }

    private void resetQuery(){
        sb.setLength(0);
        tableName = "";
    }
}
