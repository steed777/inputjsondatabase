package input.convert;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;

public class Writer {
private static final String dbFile = "dbFile.json";

public static void addJson(ResultSetConverter resultSetConverter) throws IOException, SQLException{
    StringWriter stringWriter = new StringWriter();
    ObjectMapper objectMapper = new ObjectMapper();

    objectMapper.writeValue(stringWriter, dbFile);
    String result = stringWriter.toString();
   // System.out.println(result);
    /*FileWriter fileWriter = new FileWriter(dbFile);
    fileWriter.write(resultSetConverter.convertInJson().toString());
fileWriter.flush();*/
}
}
