package src.com.concurrency.creat;

public class CreateThread3 {

    private int i;

    private byte[] bytes = new byte[1024];

    private static int counter = 0;

    //JVM will create a thread  named "main"
    public static void main(String[] args) {
        //create JVM stack
        int j = 0;
        int[] arr = new int[1024];
        try {
            add(0);
        }catch (Error e){
            e.printStackTrace();
            //StackOverflowError 栈溢出 21438
            System.out.println(counter);
        }

    }
    private static void add(int i){
        ++counter;
        add(i+1);
    }
}
