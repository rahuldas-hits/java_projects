package banktest;

import java.util.*;
public class Login
{
    //decalaration of varaiable 
    String userid,pass;
    int sel;

    //create am objectg for class TransferMoney
    TransferMoney TransferMoneyObj = new TransferMoney();
    WithdrawlMoney WithdrawlMoneyObj = new WithdrawlMoney(); 
    ChangePassword ChangePasswordObj = new ChangePassword();

    Scanner sc = new Scanner(System.in);
    void login()
    {
        System.out.println("Connected to login page");
        System.out.println("Enter user id : ");
        userid = sc.nextLine();
        System.out.println("Password : ");
        pass = sc.nextLine();
        
      /*UserID and password must be checked in database*/      
        String sqlLogin = "select * from LOGIN WHERE USERID = 'userid' AND password = 'password';"; 
        /*
        String query = "select userid,password FROM login;";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet()
         while(rs.next()){
                db_username = rs.getString("username");
                db_password = rs.getString("password");
                //check null's also 
                if(userid.equals(userid) && password.equals(password)){
                   System.out.println("sucess");
        */
        if(userid.equals(sc) )
        {
            System.out.println(" 1.Transfer \n 2.Withdrawl \n 3.Changed Password ");
            System.out.println("Chose an option : ");
            sel = sc.nextInt();
            
            switch(sel)
            {
                case 1 :
                    System.out.println("Now you are able to transfer money.");
                    TransferMoneyObj.transfer();
                    break;
                    
                case 2 :
                    System.out.println();
                    WithdrawlMoneyObj.Withdrawl();
                    break;
                case 3 :
                    System.out.println();
                    ChangePasswordObj.Change();
                    break;
                default:
                    System.out.println("Out of option : ");
            }
        }
        else 
        {
            System.out.println("login denied ");
        }
    }
}