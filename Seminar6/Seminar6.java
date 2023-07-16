package Seminar6;

import java.util.HashMap;
public class Seminar6 {
  
    private static HashMap <Integer, Object> hashMap = new HashMap<>();

    private static final Object PRESENT  = new Object();
    public static void main(String[] args) throws Exception {
        add(100);
        add(200);
        add(350);
        add(500);
        add(1000);
        
        System.out.println(ToString());

        System.out.println(gettkey(1));
        System.out.println(gettkey(4));
    }

    private static int gettkey(int num) {
        return (Integer)hashMap.keySet().toArray()[num];
    }

    private static String ToString(){
        return hashMap.keySet().toString();
    }

    public static void add(Integer numbers) {
        hashMap.put(numbers, PRESENT);
    }            
}  

        

