package convert;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultSetConverter {

    private static final String url =
            "jdbc:firebirdsql://localhost:3050/C:/db/LAWYERS_PORTAL.FDB?lc_ctype=WIN1251&user=SYSDBA&password=masterkey";
    private static JSONArray json = null;
    private static JSONObject obj = null;
    private static JSONArray allTables = null;
    public JSONArray convertInJson()throws SQLException, JSONException{

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;

        List<String> sql = new ArrayList<String>(); // добавление в список трех sql запросов
        sql.add("select * from CANSELLEDCERTIFICATES");
        sql.add("select * from CHANGE_FIO_FILTER");
        sql.add("select * from FOREIGN_LAWYERS");
        sql.add("select * from LAWYERS");

        for (int j = 0; j < sql.size(); j++) {// попытка поместить в json объект трех таблиц
           resultSet = statement.executeQuery(sql.get(j));
           ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
           int numColumns = resultSetMetaData.getColumnCount();
           json = new JSONArray();

           while (resultSet.next()) {
               obj = new JSONObject();
               allTables = new JSONArray();
               for (int i = 1; i < numColumns + 1; i++) {
                   String column_name = resultSetMetaData.getColumnName(i);
                   if (resultSetMetaData.getColumnType(i) == java.sql.Types.BIGINT) {
                       obj.put(column_name, resultSet.getLong(column_name));
                   } else if (resultSetMetaData.getColumnType(i) == java.sql.Types.INTEGER) {
                       obj.put(column_name, resultSet.getInt(column_name));
                   } else if (resultSetMetaData.getColumnType(i) == java.sql.Types.VARCHAR) {
                       obj.put(column_name, resultSet.getString(column_name));
                   }
               }
               allTables.put(obj);
               System.out.println(allTables);
           }
        }
        return allTables;
    }
}
