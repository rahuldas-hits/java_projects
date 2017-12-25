package interfaceprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public interface NewInterface2 
{
  Connection conn = null;
    default Statement try_catch()
    {
        try
            {
            // create a mysql database connection
            String myDriver = "oracle.jdbc.OracleDriver";
            String myUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "system", "Welcome1");

            // create the mysql insert preparedstatement
//             
            Statement stmt = (Statement)conn.createStatement();
            System.out.printf("Database is successfully connected.");
            System.out.println("");
//          System.out.println("statement is : "+ stmt);
            return stmt;
            
        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
     System.out.println("else part is returning");
     return null;   
    }
}
