package src.com.concurrency.Exception;
//测试线程异常捕获和抛出的问题
public class ThreadException {

//    private final static int A = 10;
//    private final static int B = 0;

    public static void main(String[] args) {

        new Test1().test();
//        Thread t = new Thread(()->{
//            try {
//                Thread.sleep(5_000);
//                int result = A/B;
//                System.out.println(result);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        //捕获线程的异常
//        t.setUncaughtExceptionHandler((thread,e)->{
//            System.out.println(e);
//            System.out.println(thread);
//        });
//
//        t.start();
    }
}
