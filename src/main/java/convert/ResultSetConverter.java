package convert;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class ResultSetConverter {

    private static final String url =
            "jdbc:firebirdsql://localhost:3050/C:/db/LAWYERS_PORTAL.FDB?lc_ctype=WIN1251&user=SYSDBA&password=masterkey";
    private static final String dbFile = "dbFile.json";

    private boolean exit = true;
    private static JSONArray json = null;
    private static JSONObject obj = null;
    private String sql;

    public String getSql() {
        return sql;
    }
    public void setSql(String sql) {
        this.sql = sql;
    }

    public void convertInJson()throws SQLException, JSONException{

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

         json = new JSONArray();
         obj = new JSONObject();

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int numColumns = resultSetMetaData.getColumnCount();

        while (resultSet.next()) {
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
            if (resultSet == null) exit = false;
         //   System.out.println(json);
            json.put(obj);
            //System.out.println(json);
          // System.out.println(json);
        }
        //System.out.println(json);
    }
    public JSONArray convert() throws SQLException, JSONException {

      /*  sql = "select * from CANSELLEDCERTIFICATES";
        convertInJson();
        sql = "select * from CHANGE_FIO_FILTER";
        convertInJson();
        sql = "select * from FOREIGN_LAWYERS";
        convertInJson();*/
        sql = "select * from LAWYERS";
        convertInJson();
      /*  sql = "select * from NPA_RF";
        convertInJson();
        sql = "select * from SYS_ROLE";
        convertInJson();
        sql = "select * from USER_ROLE";
        convertInJson();
        sql = "select * from COUNTRIES";
        convertInJson();
        sql = "select * from NPA_FOREIGN";
        convertInJson();
        sql = "select * from REGIONS";
        convertInJson();
        sql = "select * from SYS_USER";
        convertInJson();*/

       return json;
    }
    public void write() throws SQLException, IOException {

      /*  ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 0; i < 10; i++){
        objectMapper.writeValue(new File(dbFile), convert());}*/
        FileWriter fileWriter = new FileWriter(dbFile);
        for (int i = 0; i < 10; i++){
            fileWriter.write(convert().toString());
           // System.out.println(convert().toString());
        }
        //fileWriter.flush();
    }
}
