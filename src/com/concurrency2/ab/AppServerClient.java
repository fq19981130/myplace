package src.com.concurrency2.ab;

public class AppServerClient {

    public static void main(String[] args) throws InterruptedException {

        Appserver appserver = new Appserver(13345);
        appserver.start();

        Thread.sleep(45_000L);

    }
}
