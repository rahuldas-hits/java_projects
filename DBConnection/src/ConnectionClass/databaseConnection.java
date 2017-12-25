package ConnectionClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class databaseConnection 
{
    public static Statement stmt;
    public Statement connectionDatabase() throws ClassNotFoundException
    {
        try {
            // create a mysql database connection
            String myDriver = "oracle.jdbc.OracleDriver";
            String myUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "system", "Welcome1");
            
            // create the mysql insert preparedstatement
//
            Statement stmt = (Statement)conn.createStatement();
//          stmt.executeQuery(query);
//          execute the preparedstatement
//          preparedStmt.execute();
            return stmt;

        
//cosing the connection
//          conn.close();
//          stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(databaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    return stmt;    
    }
    
    
    
}
