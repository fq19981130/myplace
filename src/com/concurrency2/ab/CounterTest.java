package src.com.concurrency2.ab;

public class CounterTest {

    public static void main(String[] args) throws InterruptedException {
        CounterIncream counterIncream = new CounterIncream();
        counterIncream.start();

        Thread.sleep(10_000L);
        counterIncream.close();
    }
}
