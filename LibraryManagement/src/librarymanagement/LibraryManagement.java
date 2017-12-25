    package librarymanagement;

import java.sql.*;
import java.util.*;
import java.sql.Statement;

public class LibraryManagement 
{
    //private static final int RESERVED_BY = 0;
    //Globally declare for use through out the program
    static Scanner in = new Scanner(System.in);
    static String srchSubQuery = "";
    static String updateQuery = "";
    static String startquery ="";
    static String sqlUpdate ;
    static String startCount = "";
    static String STUDENTID , NAME , BRANCH ,CONTACT_DETAIL ,BOOK_BORROWED ;
    static String updateRecordInQuery;
    static String unreservedABook;
    static String insertData;
    static String CallinsertNewBookRecord;
    static String countTuple ;
            
    //Scanner class for to take input from user 
    static Scanner scn = new Scanner(System.in);
    private static Object RSUnsserve;
	
    //main method called here
    public static void main(String[] args) 

    {
    //Display option to user to proced forward in the program
    System.out.println("\t\t\t\t\t  Welocme to libary management system");
    System.out.println();
    System.out.println("1.Search a book in libary");
    System.out.println("2.Reserve a book");
    System.out.println("3.Borrow a book");
    System.out.println("4.Unserve a book");
    System.out.println("5. Enter new record for book");
    System.out.println("Select a number from option as given above");
    int num = in.nextInt();
	
    //search bookname will store in bookname(variable)
    System.out.println("Enter subject name to search : ");
    String bookname = in.next();	

    try 
    {	
        String RSUnreserve = "";
        String startCount = "";
        String startquery = "";
        String countTupleRes = "";
        boolean update = false;
        boolean search = false;
        boolean unrerved = false;
        boolean insert = false;
        boolean reserved = false;
        boolean NewBookRecord = false;

        //connection part
        //link to databasae for query in database
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Welcome1");
        //Connection conn = Libary.getConnection();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        

        //num is  used in switch for what type of operation we want to operate
        switch(num)
        {
            case 1:
                    //search book from database
                    startquery = Search(bookname);
                    System.out.println(startquery);
                    startCount = CountRows(bookname);
                    search = true;
                    break;

            case 2:
                    //Insert student detail for reserving a book
                    updateRecordInQuery = updateRecord(bookname);
                    System.out.println("case 2 query : " + updateRecordInQuery);
                    countTupleRes = CountTuple(bookname); 
                    update = true;
                    break;
            case 3:
                    //Borrow a book
                    insertData = insert(bookname);
                    insert = true;
                    break;
            case 4:
                    //unreserve a book
                    System.out.println("Student id no : ");
                    int STUDENTID = scn.nextInt();
                    String sqlUnreserve = "SELECT * FROM BOOKS";
                    System.out.println(sqlUnreserve);
                    PreparedStatement ps = con.prepareStatement(sqlUnreserve);
                                   
                    System.out.println(RSUnreserve);

                    if(RSUnsserve != null)
                    {
                        unreservedABook = unreserveABook(bookname);//CALLED A FUNCTON TO UPDATE VALUE AS NULL
                        System.out.println("SUCCESSFULLY UNRESERVED THE BOOK ");
                        unrerved = true;
                    } 
                    else
                            System.out.println("you have not reserved the book yet");


                    
            case 5: System.out.println("you have selected case 5"); 
                    String CallinsertNewBookRecord = insertNewBookRecord(bookname);
                    NewBookRecord = true;
                    System.out.println("Case : " +CallinsertNewBookRecord);
                    break;
            
            default : System.out.println("Something went wrong please try again");

                    break;
            
            
        }
        
        System.out.println("out of switch statement");
        //used in case 3
        if(insert == true)
        {   
            System.out.println("Here insert becomes true.");
//          st = con.prepareStatement(insertData);
            System.out.println("value of insert data is : "+insertData);   
             
            st = con.prepareStatement(insertData);
            int RSUpdate = st.executeUpdate(insertData);
            st.close();
             
//            ResultSet rs = st.executeQuery(insertData);

            System.out.println("insert into database successfully!!!");
        }

        //used in case 2
        //to update data in table books
        else if(update == true)
        {
            System.out.println("here update becomes true");
            
            ResultSet countRS = st.executeQuery(countTupleRes);			
            countRS.last();
            if(countRS.getInt(1)<1)
            {
                st = con.prepareStatement(updateRecordInQuery);
                int RSUpdate = st.executeUpdate(updateRecordInQuery);
                System.out.println("SUCCESS!!!" + RSUpdate);
            }
            else
            {
                System.out.println("Sorry book is already reserbed by someone ");
            }
            
        }
        else if (unrerved == true)
        {
            //3RD case unserve a book 
            System.out.println("here unreserved becomes true");
            st = con.prepareStatement(unreservedABook);
            int RSUnserved = st.executeUpdate(unreservedABook);
            System.out.println("SUCCESS!!!");
        }
        else if(NewBookRecord == true)
        {
            System.out.println("here new book record becomes true");
            ResultSet Result = st.executeQuery(CallinsertNewBookRecord);
//            ResultSet InsertRecord  = st.executeQuery(CallinsertNewBookRecord);
            System.out.println(Result);
            System.out.println("Successfully update new record");
        }

        else if(search == true)
        {
            System.out.println("here search becomes true");
            //Count Result Set
            //Here run the Count query
            System.out.println("Search becomes true");
            ResultSet countRS = st.executeQuery(startCount);			
            countRS.last();
            //System.out.println("the size"+countRS.getInt(1));
            ResultSet rs = null;
            if(countRS.getInt(1) > 0)
            {
                countRS.close();				
                //Main result set to get the data
                rs = st.executeQuery(startquery );

                System.out.println("Subject found");
                //Boolean isBookAvailable;

                while(rs.next()){					
                    System.out.println("We have found the book for you. Here are the details : ");
                    System.out.println("subject : "+rs.getString(1)+" book id : "+rs.getString(2) + " Reserved by : " + rs.getString(3) + " " + rs.getString(4)+ " " 
                                    + rs.getString(5)+ " " + rs.getString(6)+ " " /*+ rs.getString(7)+ " " + rs.getString(8)*/);


//                                System.out.println("Author  : "+rs.getString("Author"));

                    //Verify if the Book is Available
                    if(rs.getString("BORROWED_BY") == null)
                    {
                            
                            //Verify if the book is already reserved
                            if(rs.getString("RESERVED_BY") == null)
                            {
                                    System.out.println("Would you like to borrow the book");
                                    System.out.println("Type yes or no");
                                    String result = in.next();
//                                        System.out.println(result);

                                    if( result.equalsIgnoreCase("yes") )
                                            {
                                               //called reserved function
                                               System.out.println("Enter your student id : ");
//                                               int studentid = scn.nextInt();
//                                                   System.out.println("Student id is : " +studentid);
                                               String updateBorrowed_by = borrowedRecord(bookname);
                                               reserved = true;
                                               if(reserved == true)
                                                        {
                                                            st = con.prepareStatement(updateBorrowed_by);
                                                            int reservedUpdate = st.executeUpdate(updateBorrowed_by);
                                                            System.out.println("SUCCESS!!!");
                                                        }

                                            }
                                            else 
                                            {
                                                    System.out.println("Thank you !!!");
                                            }
                            }
                            else
                            {
                                    System.out.println("The book is not available");
                            }
                    }
                    else if(rs.getString("BORROWED_BY") != null)
                    {
                        if(rs.getString("RESERVED_BY") == null)
                        {
                            System.out.println("Book is already borrowed.");
                            System.out.println("Would you like to reserve the book");
                            System.out.println("Type yes or no");
                            String result = in.next();
                            //System.out.println(result);
                            if(result.equalsIgnoreCase("yes"))
                            {
                                System.out.println("Enter your detail");
                                updateRecordInQuery = updateRecord(bookname);
                                update = true;

                            }
                            else 
                            {
                                System.out.println("Thank you !!!");
                            }
                        }
                        else
                        {
                            System.out.println("The book is not available");
                        }

                    }
                    else 
                    {
                            System.out.println("The book is available");
                    }			

                }
                
            }
            else{
                    System.out.println("Please try searching with a different keyword");				
            }

            rs.close();	
            con.close();
        }			
    } 
    catch (Exception e) 
    {
        System.out.println(e);

    }
}

    private static Connection getConnection() {
            // TODO Auto-generated method stub
            return null;
    }

    public static String Search(String bookName)
    {	
            System.out.println("I am in 1 function");
            String srchSubQuery = "SELECT * FROM BOOKS Where NAME ='" + bookName.toLowerCase() + "'";
            return srchSubQuery;
    }

    public static String CountRows(String bookName)
    {
        String countSql = "";
        countSql = "SELECT count(*) FROM BOOKS Where NAME ='" + bookName.toLowerCase() + "'";
        System.out.println("I am in 2 function");
        return countSql;
    }

    public static String insert(String bookname)
    {
      //Borrow a book  
      System.out.println("Enter sttuent id : ");  
      int studentid = scn.nextInt();
      String sqlInsert = "UPDATE books SET borrowed_by = " +studentid+ " WHERE name = '" + bookname +"';" ;
      System.out.println(sqlInsert);
      return sqlInsert;

    }

    public static String updateRecord(String bookname)
    { 
        //update the record in both table 
        System.out.println("Enter student id no : ");
        int studentid = scn.nextInt();
        String sqlUpdate = "UPDATE BOOKS SET reserved_by = " + studentid + " WHERE NAME = \'"+ bookname+ "\'";
        System.out.println("Sql value is : " + sqlUpdate);
        return sqlUpdate ;				
    }

    public static String unreserveABook(String bookname)
    {	
        String sqlDelete = "UPDATE TABLE SET RESERVED_BY = null WHERE  RESERVED_BY ='"+ STUDENTID + "'";
        return sqlDelete;
    }   
    public static String reservedRecord(String bookname)
    { 
        //update the record in both table 
        System.out.println("Enter student id no : ");
        int studentid = scn.nextInt();
        String sqlUpdate = "UPDATE BOOKS SET reserved_by = " + studentid + " WHERE NAME = \'"+ bookname+ "\'";
        System.out.println("Sql value is" + sqlUpdate);
        return sqlUpdate ;				
    }    
    
    public static String insertNewBookRecord(String bookname)
    {
        System.out.println("Enter book name : ");
        String name = scn.nextLine();
        System.out.println("Enter book unique id  : ");
        String bookid = scn.nextLine();
        
        String NewRecord =  "insert into books (name,book_id) values ( '" +name+"' , " +bookid+ ");"  ;
        
        System.out.println("Function call "+NewRecord);
        return NewRecord;
    }
    
    public static String borrowedRecord(String bookname)
    { 
        //update the record in both table 
        System.out.println("Enter student id no : ");
        int studentid = scn.nextInt();
        String sqlUpdate = "update books set borrowed_by = " + studentid + "where name = '"+ bookname+ "'";
        System.out.println("Sql value is" + sqlUpdate);
        return sqlUpdate ;				
    }
    
     public static String CountTuple(String bookName)
    {
        String countSql = "";
        System.out.println("Enter student id : ");
        int studentid = scn.nextInt();
        countSql = "SELECT count(reserved_by) FROM BOOKS Where reserved_by ='" + studentid + "'";
        return countSql;
    }
        
}