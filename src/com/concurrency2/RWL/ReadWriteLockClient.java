package src.com.concurrency2.RWL;
//读写锁设计模式
public class ReadWriteLockClient {

    public static void main(String[] args) {
        final ShareData shareData = new ShareData(10);
        new ReaderWorker(shareData).start();
        new ReaderWorker(shareData).start();
        new ReaderWorker(shareData).start();
        new ReaderWorker(shareData).start();
        new ReaderWorker(shareData).start();
        new WriteWorker(shareData,"eweviywtev").start();
        new WriteWorker(shareData,"eweviywtev").start();
    }
}
