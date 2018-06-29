package Services;

import Models.DBQueryModel;

public class QueryBuilder {
    private StringBuilder sb = new StringBuilder();
    private String tableName;


    public void buildQuery(DBQueryModel queryModel) {
        if (queryModel.getTable() != null) {
            resetQuery();
            tableName = queryModel.getTable();
            sb.append("SELECT * FROM ").append(tableName).append(" WHERE 1 = 1");
        } else if (queryModel.getTable() == null && (tableName == null || tableName.isEmpty())) {
            //TODO what should happen here ???
            System.out.println("You should have given me a table name...");
            return;
        }

        if (queryModel.getWhere() != null && queryModel.getWhereValue() != null) {
            whereClause(queryModel);
        }

    }

    public void whereClause(DBQueryModel queryModel) {
        String[] values = queryModel.getWhereValue();
        sb.append(" AND ").append(queryModel.getWhere()).append(" IN (");
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
