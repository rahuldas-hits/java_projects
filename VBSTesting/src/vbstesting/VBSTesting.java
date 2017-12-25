package vbstesting;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VBSTesting {
    public static void main(String[] args){
      try{
        Runtime.getRuntime().exec( "wscript C://Users//Rahul//Desktop//Java_Test/greeting.vbs" );      
        Runtime.getRuntime().exec( "wscript C://Users//Rahul//Desktop//Java_Test/Talk.vbs" );
       }
       catch( IOException e ) {
          System.out.println(e);
          System.exit(0);
       }
    }
    
}
