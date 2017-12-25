package conexion;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "test";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "userparatest";
        String password = "userparatest";

        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + dbName, userName,password);

        return conn;
    }
}
