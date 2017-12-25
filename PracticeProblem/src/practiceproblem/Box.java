package practiceproblem;

public class Box 
{
    double height,width,breadth;
    Box()
    {
        height=15;
        width=15;
        breadth=15 ;
    }
    Box(double h,double w,double b)
    {
        height = h;
        width = w;
        breadth = b;
        
    }
    
    public double volumne()
    {
        return (width*height*breadth);
    }
    
}
