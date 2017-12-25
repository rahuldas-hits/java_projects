package connectdb;
import java.sql.*;
 
public class ConnectDB {
     
    private static Connection connect;
    private static ConnectDB instance;
    PreparedStatement prepareStatement ;
     
    private ConnectDB()
    {
         
        try {
             
            Class.forName("oracle.jdbc.OracleDriver");
            //connect DB
            connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Welcome1");
            System.out.println("Connection part");
 
             
        }
         
        catch(SQLException e)
        {
            System.out.printf("Sql exception ");
            System.err.println(e.getMessage());
            
             
        }
         
        catch(ClassNotFoundException e)
        {
            System.out.printf("Class not found"); 
            System.err.println(e.getMessage());
            
             
        }
         
 
         
    }
     
      public static ConnectDB getInstance()
      {
           
          if(instance == null) {
               
              instance = new ConnectDB();
               
          }
           
          return instance;
 
           
      }
 
}
