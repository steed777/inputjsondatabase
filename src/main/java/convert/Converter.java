package convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Converter {
private static final String dbFile = "dbFile.json";
    public static void toJson(ResultSetConverter resultSetConverter)throws IOException, SQLException {
        /*ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(dbFile), resultSetConverter.convert());*/
    }
/*public static ResultSetConverter toJavaObject() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(dbFile), ResultSetConverter.class);
}*/


/*public static void addJson(ResultSetConverter resultSetConverter) throws IOException, SQLException{
   // JSONObject jsonObject = new JSONObject();
    FileWriter fileWriter = new FileWriter(dbFile);
    fileWriter.write(resultSetConverter.convert().toString());
fileWriter.flush();
}*/
}
