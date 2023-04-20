package src.com.concurrency2.ischange;

public class ImmutablePerformance {

    public static void main(String[] args) throws InterruptedException {
        //加锁  time3140  time8462
        long startTimestamp = System.currentTimeMillis();
        SyncObj syncObjc= new SyncObj();//加锁
        syncObjc.setName("Alex");
        //不加锁 ime3159  time8683
        //ImmutableObj immutableObj = new ImmutableObj("Alex");
        Thread t1= new Thread(() -> {
            for (long l = 0L;l < 1000000; l++){
                System.out.println(Thread.currentThread().getName() + "=" + syncObjc.toString());
            }
        });
            t1.start();
        Thread t2= new Thread(() -> {
            for (long l = 0L;l < 1000000; l++){
                System.out.println(Thread.currentThread().getName() + "=" + syncObjc.toString());
            }
        });
        t2.start();
        t1.join();
        t2.join();


//        for (long l = 0L;l < 1000000; l++){
//            System.out.println(immutableObj.toString());
//        }

        long endTimestamp = System.currentTimeMillis();
        System.out.println("Elapsed time"+(endTimestamp-startTimestamp));
    }
}
//不可变对象
class ImmutableObj{
    private final String name;

    ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "["+name+"]";
    }
}

//可变对象
class SyncObj{
    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}


