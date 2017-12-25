package practiceproblem;
public class PracticeProblem {

    public static void main(String[] args) {
        
        /*Array arrayObj = new Array();
        arrayObj.ArrayClass();*/
        /*ContinueClass continueObj = new ContinueClass();
        continueObj.pattern();*/
        Box boxObj = new Box();
        double res = boxObj.volumne();
        System.out.println(res);
        
        Box boxObj2 = new Box(30,40,50);
        System.out.println(boxObj2.volumne()        );
        
       /*
        // TODO code application logic here
        System.out.println("Hello world!!!!!!!");
        byte b =1;
        short sh = 1;
        int i= 1;
        long l = 1L;
        float f = 1f;
        double d = 1d;
        System.out.println("byte : "+b);
        System.out.println("short : "+sh);
        System.out.println("int :"+ i);
        System.out.println("long : "+l);
        System.out.println("float : "+f);
        System.out.println("doiible : "+d);
        System.out.print("End of first main method");  
        b++;
        System.out.println( "Byte : "+b);
        */
    }   
}
