package javaapplication1;

/**
 *
 * @author sasha
 */
public class Main {

    public static void main(String[] args) {
        HashMap hm = new HashMap();
        
        System.out.println("Zero size: " + hm.size() + "\n");
        
        System.out.println("Putting 2 values...\n");
        hm.put(2313123L, 381);
        hm.put(2830219398L, 1);
        System.out.println(hm);
        
        System.out.println("Changing values...\n");
        hm.put(2313123L, hm.get(2313123L) - 1); 
        hm.put(2830219398L, hm.get(2830219398L) + 1); 
        System.out.println(hm);
        
        System.out.println("Checking the size...\nSize: " + hm.size() + "\n");
        
        System.out.println("Trying value with no key...\n");
        try {
            hm.get(0L);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    
}