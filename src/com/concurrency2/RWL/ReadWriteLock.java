package src.com.concurrency2.RWL;
//读写锁分离demo
public class ReadWriteLock {

    private int readingReaders = 0;
    private int waitingReaders = 0;
    private int writingWriters = 0;
    private int waitingWriters = 0;
    private boolean preferWriter = true;

    public ReadWriteLock(){
        this(true);
    }

    public ReadWriteLock(boolean preferWriter){
        this.preferWriter = preferWriter;
    }

    //添加synchronized
    public synchronized void  readLock() throws InterruptedException{
        this.waitingReaders++;
        try {
            while (writingWriters > 0  || (preferWriter && waitingWriters > 0)){
                this.wait();
            }
            this.readingReaders++;
        }finally {
            this.writingWriters--;
        }
    }
    public synchronized void readUnlock(){
        this.readingReaders--;
        this.notifyAll();
    }
    public synchronized void writeLock() throws InterruptedException{
        this.writingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0){
                this.wait();
            }
            this.writingWriters++;
        }finally {
            this.writingWriters--;
        }
    }
    public synchronized void writeUnlock(){
        this.writingWriters--;
        this.notifyAll();
    }
}
