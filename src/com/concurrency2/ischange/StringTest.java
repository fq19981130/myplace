package src.com.concurrency2.ischange;

public class StringTest {

    public static void main(String[] args) {
        String s = "Hello";
        String s2 = s.replace("1","k");
        System.out.println(s2);
        System.out.println(s2.getClass()+" "+s2.hashCode());
        System.out.println(s.getClass() +" "+ s.hashCode());
    }
}
