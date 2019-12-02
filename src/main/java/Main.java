import convert.Writer;
import convert.ResultSetConverter;

import java.io.IOException;
import java.sql.*;

public class Main{

    public static void main(String[] args) throws SQLException, IOException {
        ResultSetConverter resultSetConverter = new ResultSetConverter();
        Writer converter = new Writer();

      //  resultSetConverter.convert();
        resultSetConverter.convertInJson();
        converter.addJson(resultSetConverter);

    }
}
