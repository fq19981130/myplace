package src.com.concurrency2.volatil;

public class VolatileTest1 {

    private volatile static int INIT_VALUE = 0;

    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {

        new Thread(()->{

            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT){
                if (localValue != INIT_VALUE){
                    System.out.printf("The Value upload to [%d]",INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }

        },"READER").start();
        new Thread(()->{
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_LIMIT){
                System.out.printf("Update value updated to [%d]\n",++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"UPDATER").start();
    }
}
