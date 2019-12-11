package input.convert;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@JsonAutoDetect
public class ResultSetConverter {

    private static final String url =
            "jdbc:firebirdsql://localhost:3050/C:/db/LAWYERS_PORTAL.FDB?lc_ctype=WIN1251&user=SYSDBA&password=masterkey";
    private static JSONObject obj = null;
    private static JSONArray allTables = null;

    public JSONArray convertInJson()throws SQLException, JSONException{

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;

        List<String> sql = new ArrayList<String>();
        sql.add("select * from CANSELLEDCERTIFICATES");
        sql.add("select * from CHANGE_FIO_FILTER");
        sql.add("select * from FOREIGN_LAWYERS");
        sql.add("select * from LAWYERS");
        sql.add("select * from NPA_RF");
        sql.add("select * from SYS_ROLE");
        sql.add("select * from USER_ROLE");
        sql.add("select * from CANSELLED_CERTIFICATES");
        sql.add("select * from COUNTRIES");
        sql.add("select * from GLOSSARY");
        sql.add("select * from NPA_FOREIGN");
        sql.add("select * from REGIONS");
        sql.add("select * from SYS_USER");

        allTables = new JSONArray();

        for (int j = 0; j < sql.size(); j++) {
           resultSet = statement.executeQuery(sql.get(j));
           ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
           int numColumns = resultSetMetaData.getColumnCount();

           while (resultSet.next()) {
               obj = new JSONObject();
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
               }
        }
        //System.out.println(allTables);
      return allTables;
    }

}
