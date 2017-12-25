package connectdb;
import connectdb.ConnectDB;
import connectdb.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Mian 
{
    public static void main(String args[]) throws SQLException
    {

        ResultSet rs = null;
        PreparedStatement ps;
        ConnectDB con = ConnectDB.getInstance();
        ps = con.prepareStatement;
        String query = " select * from aaqib ";
        
        ps.executeQuery(query);
        System.out.println("Query " + query);
        
            while(rs.next())
            {
                System.out.println("Result set");
                int course_id = rs.getInt("course_name");
                System.out.println("Course id : " + course_id);
            }
        
         
        
    }
}
