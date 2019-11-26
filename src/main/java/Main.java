import convert.Converter;
import convert.ResultSetConverter;

import java.io.IOException;
import java.sql.*;

public class Main{

    public static void main(String[] args) throws SQLException, IOException {
        ResultSetConverter convertJson = new ResultSetConverter();
       convertJson.convert();
        Converter converter = new Converter();
      converter.toJson(convertJson);
    }
}
