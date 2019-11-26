package convert;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Converter {
private static final String dbFile = "dbFile.json";
    public static void toJson(ResultSetConverter resultSetConverter)throws IOException, SQLException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(dbFile), resultSetConverter.convert());
    }
}
