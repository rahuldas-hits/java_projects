package banktest;
import java.util.*;

public class ChangePassword extends Login
{
    //declaration of variable
    String new_pass;
    Scanner sc = new Scanner(System.in);
    
    void Change()
    {
        System.out.println("Enter your current password : ");
        new_pass = sc.nextLine();
        if( pass.equals(sc) )
        {
            System.out.println("Enter new password : ");
            new_pass = sc.nextLine();
            String ChangePassSql = "Update into BANK where user_id = '"+userid +"'";
//          UPDATE BANK SET "CITY" = 'Guwahati(Assam)' WHERE ACCOUNT_NO = 1234567890;          
        }
    }
}
