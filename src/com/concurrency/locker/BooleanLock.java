package src.com.concurrency.locker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class BooleanLock implements Lock{

    //The initValue is true indicates the lock have be get
    //The initValue is false indicates the lock is free (other Thread can get this.)
    private boolean initValue;

    private Collection<Thread> blockThreadCollection = new ArrayList<>();

    private Thread currentThread;

    public BooleanLock(){
        this.initValue=false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue){
            blockThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        blockThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills <=0)
            lock();
        long hasRemaining = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (initValue){
            if (hasRemaining <=0)
                throw new TimeOutException("Time out");
            blockThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            hasRemaining = endTime - System.currentTimeMillis();
        }
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentThread) {//加控件控制线程释放
            this.initValue = false;
            Optional.of(Thread.currentThread() + " release the lock monitor.")
                    .ifPresent(System.out::println);
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockThreadCollection.size();
    }
}
