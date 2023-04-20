package src.com.concurrency.Interrupt;
//强制终止线程
public class ThreadCloseCloseful3 extends Thread{

    @Override
    public void  run(){

        while (true){
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    break;//return
//                }
            if (Thread.interrupted())
                break;
        }
    }
}
