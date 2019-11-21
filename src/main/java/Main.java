import java.sql.*;

public class Main{

    public static void main(String[] args) throws SQLException{
        ResultSetConverter convertJson = new ResultSetConverter();
       convertJson.convert();
    }
}
