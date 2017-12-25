package interfaceprogram;

import java.sql.SQLException;

public class InterfaceProgram implements NewInterface1,NewInterface2
{
    public static void main(String[] args) throws SQLException 
    {
        
//        InterfaceProgram d = new InterfaceProgram();
//        d.show();
        test obj = new test();
        obj.check();
    
    }
    
}
