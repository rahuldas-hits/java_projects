package connectionoraclee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ConnectionOraclee 
{

     public static void main(String[] args)
  {
      Scanner sc = new Scanner(System.in);
      
    
    try
    {
      // create a mysql database connection
      String myDriver = "oracle.jdbc.OracleDriver";
      String myUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "system", "Welcome1");
    
      // create a sql date object so we can use it in our INSERT statement
      System.out.println("Enter First name : ");
      String first = sc.nextLine();
 
      // the mysql insert statement
      String query = " insert into TEST values ('"+first+"' )";

      // create the mysql insert preparedstatement
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery("Select * from test");
      
     // execute the preparedstatement
      preparedStmt.execute(query);
      
      while(rs.next())
      {
          System.out.println("Name:"+rs.getString(1) );
          System.out.println();
      }
      conn.close(); 
      rs.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
}
