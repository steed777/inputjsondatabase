import convert.Converter;
import convert.ResultSetConverter;

import java.io.IOException;
import java.sql.*;

public class Main{

    public static void main(String[] args) throws SQLException, IOException {
        ResultSetConverter resultSetConverter = new ResultSetConverter();
        resultSetConverter.convert();
        resultSetConverter.write();
       // Converter converter = new Converter();
      //converter.toJson(resultSetConverter);
        //System.out.println(converter.toJavaObject());
       // converter.addJson(resultSetConverter);
     //   System.out.println(resultSetConverter.convert());
    }
}
