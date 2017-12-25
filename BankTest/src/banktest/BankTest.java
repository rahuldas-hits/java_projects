package banktest;

//import connectionDb.connectionClass.*;
import java.util.*;

public class BankTest
{
    public static void main(String[] args)
  {
    //creating a reference for Scanner calass.  
    Scanner sc = new Scanner(System.in);
    String userid,password;
    //Decalaration of varaiable
    int option; 

    //Creating object to call from another class
    NewAccount objNewAccount = new NewAccount();//creating object for NewAccount method
    UpdateAccount objUpdateAccount = new UpdateAccount();//creating object for UpdateAccount method
    Login LoginObj = new Login();
         

        System.out.println(" Welcome to Online banking site .");//simple statement
        System.out.println(" 1.Sign Up \n 2. log in ");
        option = sc.nextInt();//taking input from user to chose their option.
        
        switch(option)
        {
            case 1 :
                System.out.println("Select type of account to create.");
                System.out.println();
                objNewAccount.NewAccountCall();
                break;
                
            case 2:
                System.out.println("Select an update option from given below :");
                LoginObj.login();
                break;
                
            default :
                System.out.println("Chose an wrong option ");
                break;
        }
    }
   
}
    

