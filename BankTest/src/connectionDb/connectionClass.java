package connectionDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connectionClass 
{
     void try_catch()
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
         //     stmt.executeQuery(query);
              // execute the preparedstatement
        //      preparedStmt.execute();
              System.out.printf("Database is successfully connected.");
             
             //cosing the connection 
              //conn.close();
            // stmt.close();

        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
    }    
}    

