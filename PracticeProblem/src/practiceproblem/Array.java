package practiceproblem;

//import java.util.*;

public class Array 
{
    void ArrayClass()
    {
        /*System.out.println("I am in array class...");
        int month_day[];
        month_day = new int[12];
        month_day[3] = 31;
        
        for(int i=0;i<5;i++)
        {
            System.out.println(month_day[i]);
        }
        
        int mulArray[][] = new int[3][3];
        
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.println(mulArray[i][j]);
        }   }*/
        
        
        int threeDMatrix[][][] = new int[3][4][5];
        int i,j,k;
        for(i=0;i<3;i++)
            for(j=0;j<4;j++)
                for(k=0;k<5;k++)
                    threeDMatrix[i][j][k] = i*j*k;
        
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                for(k=0;k<5;k++)
                    System.out.println(threeDMatrix[i][j][k]+"");
                    System.out.println();
                
                
            }
            System.out.println();
        }
                       
            
    }
}
