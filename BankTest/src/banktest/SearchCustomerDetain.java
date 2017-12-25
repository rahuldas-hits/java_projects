package banktest;
import java.util.*;
import java.sql.*;
public class SearchCustomerDetain 
{
    Scanner sc =new Scanner(System.in);
    void CustomerDetail()
    {
        System.out.println("Enter user id : ");
        String user_id = sc.nextLine();
        
        //search query to search customer daetail
        String searchCustomerDetail = "select * from BANK WHERE account_no =" + user_id;
//        if(user_id == stmt.executeQuery() );
    }
    
}
