package input;

import input.convert.Writer;
import input.convert.ResultSetConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.*;



@SpringBootApplication
public class Main{
    public static void main(String[] args) throws SQLException, IOException {
        ResultSetConverter resultSetConverter = new ResultSetConverter();
        Writer converter = new Writer();
        resultSetConverter.convertInJson();
        converter.addJson(resultSetConverter);
        SpringApplication.run(Main.class, args);
    }

    }

