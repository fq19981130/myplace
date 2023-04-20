package src.com.concurrency2.RWL;

public class ReaderWorker extends Thread{

    private final ShareData data;

    public ReaderWorker(ShareData data){
        this.data = data;
    }
    @Override
    public void run(){
        try {
        while (true){
                char[] readBuf = data.read();
            System.out.println(Thread.currentThread().getName()+" read " + String.valueOf(readBuf));
                }
            }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
