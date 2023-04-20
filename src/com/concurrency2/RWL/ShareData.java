package src.com.concurrency2.RWL;
//定义数据
public class ShareData {

    //定义一个buffer
    private final char[] buffer;
    //定义锁
    private final ReadWriteLock lock = new ReadWriteLock();

    public ShareData(int size){
        buffer = new char[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = '*';
        }
    }
    public char[] read() throws InterruptedException {//读
        try {
            lock.readLock();
            return doRead();
        }finally {
            lock.readUnlock();
        }
    }
    public void write(char c) throws InterruptedException{//写
        try {
            lock.writeLock();
            this.doWrite(c);
        }finally {
            lock.writeUnlock();
        }

    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly(10);
        }
    }

    private char[] doRead(){
        char[] newBuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) 
            newBuf[i] = buffer[i];
        slowly(50);
        return newBuf;
    }

    private void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
