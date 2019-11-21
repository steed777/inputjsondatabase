import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;

public class ResultSetConverter {
    private static final String url =
            "jdbc:firebirdsql://localhost:3050/C:/db/LAWYERS_PORTAL.FDB?lc_ctype=WIN1251&user=SYSDBA&password=masterkey";
    public static JSONArray convert() throws SQLException, JSONException {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from LAWYERS");

        JSONArray json = new JSONArray();
        ResultSetMetaData rsmd = rs.getMetaData();

       /* while(resultSet.next()) {
            int numColumns = resultSetMetaData.getColumnCount();
            JSONPObject obj = new JSONPObject();
            for (int i=1; i<=numColumns; i++) {
                String column_name = resultSetMetaData.getColumnName(i);
                obj.put(column_name, resultSet.getObject(column_name));
            }
            json.put(obj);
        }
        return json;*/
        int numColumns = rsmd.getColumnCount();
        while (rs.next()) {
            JSONObject obj = new JSONObject();

            for (int i = 1; i < numColumns + 1; i++) {
                String column_name = rsmd.getColumnName(i);
                if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
                    obj.put(column_name, rs.getLong(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
                    obj.put(column_name, rs.getInt(column_name));
                } else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR) {
                    obj.put(column_name, rs.getString(column_name));
                }
            }
            json.put(obj);
        }
        return json;
    }
}
