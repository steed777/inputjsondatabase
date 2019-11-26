package convert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

public class ResultSetConverter {
    private static final String url =
            "jdbc:firebirdsql://localhost:3050/C:/db/LAWYERS_PORTAL.FDB?lc_ctype=WIN1251&user=SYSDBA&password=masterkey";
    public static JSONArray convert() throws SQLException, JSONException{
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from NPA_RF");
        ResultSet resultSet1 = statement.executeQuery("select * from SYS_ROLE");
        ResultSet resultSet3 = statement.executeQuery("select * from LAWYERS");

        JSONArray json = new JSONArray();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int numColumns = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            JSONObject obj = new JSONObject();
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
            System.out.println(json);
            json.put(obj);
        }
        return json;
    }
}
