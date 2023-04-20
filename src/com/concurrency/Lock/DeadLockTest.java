package src.com.concurrency.Lock;

public class DeadLockTest {
    public static void main(String[] args) {

        OtherService otherService = new OtherService();

        DeadLock deadLock = new DeadLock(otherService);

        otherService.setDeadLock(deadLock);

        new Thread(() -> {
            while (true){
                deadLock.m1();
            }
        }).start();

        new Thread() {
            @Override
            public void run(){
                while (true)
                    otherService.s2();
            }
        }.start();
    }
}
