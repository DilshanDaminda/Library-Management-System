package lk.ijse.dep.library.DB;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBCon {

    private static DBCon dbCon;
    private Connection connection;



    private DBCon () throws Exception{

        Properties dbProp = new Properties();

        File file  = new File("resources/application.properties");
        FileReader fileReader = new FileReader(file);

        dbProp.load(fileReader);

        String ip = dbProp.getProperty("ip");
        String port = dbProp.getProperty("port");
        String db = dbProp.getProperty("db");
        String username = dbProp.getProperty("username");
        String password =  dbProp.getProperty("password");

        String url = "jdbc:mysql://"+ip+":"+port+"/"+db;
        connection = DriverManager.getConnection(url,username,password);


    }
    public static DBCon getInstance() throws  Exception{

        if(dbCon == null){

            dbCon = new DBCon();

        }
      return dbCon;
    }

    public Connection getConnection() {
        return connection;
    }
}
