package interfaceprogram;

//import static interfaceprogram.NewInterface2.conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test implements NewInterface1 
{
    void check() throws SQLException
    {
//        NewInterface1 ob = new NewInterface1() {};
//        ob.show();
        
        NewInterface2 ob2 = new NewInterface2() {};
        
        System.out.println("Connection part is  called");
        Statement stmtobj = ob2.try_catch();
        System.out.print("returning of stmt :" + stmtobj);
        
        ResultSet rs = stmtobj.executeQuery("select * from test;");
        
        System.out.println("Query part is : ");
         while(rs.next())
      {
          System.out.println("insert into while block");
          System.out.println("Name:"+rs.getString(1));
          System.out.println();
      }
         
         rs.close();
         stmtobj.close();
        // conn.close();
        
    }   
    
}
