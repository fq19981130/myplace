package src.com.concurrency2.ThreadLocal;

public class Test {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {

        threadLocal.set("wangcai");
        Thread.sleep(1000);
        String value =(String) threadLocal.get();
        System.out.println(threadLocal.get());
    }
}
