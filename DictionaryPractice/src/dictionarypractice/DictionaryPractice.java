package dictionarypractice;

import java.util.HashMap;
import java.util.Map;

public class DictionaryPractice {

    public static void main(String[] args) {
        //English to spanish
        Map<String,String> engSpanDictinary = new HashMap<String , String>();
        
        //days of dictionary
        engSpanDictinary.put("Monday","Lunes");
        engSpanDictinary.put("Tursday","Martes");
        engSpanDictinary.put("Wednesday","Miercoles");
        engSpanDictinary.put("Thusday","Jueves");
        engSpanDictinary.put("Friday","Viernes");
        engSpanDictinary.put("Saturday","Sabado");
        engSpanDictinary.put("Sunday","Domingo");
        
        System.out.println(engSpanDictinary.get("Monday") );
        System.out.println(engSpanDictinary.get("Tuesday") );
        System.out.println(engSpanDictinary.get("Wednesday") );
        System.out.println(engSpanDictinary.get("Thusday") );
        System.out.println(engSpanDictinary.get("Friday") );
        
        //print out all keys
        System.out.println(engSpanDictinary.keySet() );
        //print out all values
        System.out.println(engSpanDictinary.values() );
        //print size of dictionary
        System.out.println(" The size of our dictionary is "+engSpanDictinary.size() );
        
    }
    
}
