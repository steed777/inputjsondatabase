package convert;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Writer {
private static final String dbFile = "dbFile.json";

public static void addJson(ResultSetConverter resultSetConverter) throws IOException, SQLException{
    FileWriter fileWriter = new FileWriter(dbFile);
    fileWriter.write(resultSetConverter.convertInJson().toString());
fileWriter.flush();
}
}
