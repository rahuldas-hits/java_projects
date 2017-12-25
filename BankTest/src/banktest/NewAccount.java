package banktest;
import java.util.Scanner;

public class NewAccount extends BankTest
{
    Scanner sc = new Scanner(System.in);
    String name,email,password,address,city,sex;
    int income,pin,choise;
    
    
    void NewAccountCall()//call for signup or create an new account
    /*Should be connect to database to store lot of lots of account to database*/
    {
        System.out.println("1.Saving account \n 2.Current account");
        choise = sc.nextInt();
        
        switch(choise)
        {
            case 1 :
                System.out.print("For saving account ");
                saving();
                break;
            case 2:
                System.out.print("For current account");
                saving();
                System.out.print("Enter annual income : ");
                break;
        }
        
    }
    
     void saving()
        {
            
            System.out.print("Name :  ");
            name = sc.nextLine();
            System.out.println();
            System.out.print("Email-id : ");
            email = sc.nextLine();
            System.out.println("sex :");
            sex = sc.nextLine();
            System.out.println("Address : ");
            address = sc.nextLine();
            System.out.println("City : ");
            city = sc.nextLine();
            System.out.println("pin code :");
            pin = sc.nextInt();
           
           //perfrom query to insert into database
/*
           String sqlInsert = "insert into BANK "+"VALUES('"+name+"','"+email+"','"+sex+"','"+address+"','"+city+"','"+pin+"')";
           stmt.executeQuery(sqlInsert);*/
           System.out.println("Your account was created successfully.");
        }
}
