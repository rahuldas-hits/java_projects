package banktest;
import java.util.Scanner;

public class TransferMoney 
{
    Scanner sc = new Scanner(System.in);
    
    //declaration of variable
    String pass;
    int account_no,ifsc_code,amount;
    
    //creating a method for login
    void LoginForTransfer()
    {
        System.out.println("Enter your password : ");
        pass =  sc.nextLine();
        //sql query for login
        String sqlLogin = "";
    /*    if(sqlLogin == pass)
        {
            transfer();
        }*/
    }
    
    //create a method for deducting amount 
    void transfer()
    {
        System.out.println("Account number : ");
        account_no = sc.nextInt();
        System.out.println("IFSC code : ");
        ifsc_code = sc.nextInt();
        System.out.println("Amount :: ");
        amount = sc.nextInt();
        
        /*First check if amount is available in account for transaction or not if possible 
          deduct it from user amount and transfer to another account
        */
        
    }
}
