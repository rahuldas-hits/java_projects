package interfaceprogram;
public interface NewInterface1 
{
    default void show()
    {
        System.out.println("I am default in newinterface 1");
    }
}
