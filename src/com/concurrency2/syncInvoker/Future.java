package src.com.concurrency2.syncInvoker;

public interface Future<T> {

    T get() throws InterruptedException;
}
