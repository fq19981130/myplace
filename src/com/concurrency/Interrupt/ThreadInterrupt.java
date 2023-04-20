package src.com.concurrency.Interrupt;

public class ThreadInterrupt {

    private static final Object MONITER = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(){

            @Override
            public void run() {
                while (true){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        System.out.println("收到打断信号.");
//                    }
//                    System.out.println(">>" + this.isInterrupted());
//                    synchronized (ThreadInterrupt.class){
//                        try {
//                           MONITER.wait(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }

                }
            }
        };
        t.start();
        Thread main = Thread.currentThread();
        Thread t2 = new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                main.interrupt();
                System.out.println("interrupt");
            }
        };
        t2.start();
        try {
            t.join();//在这个位置给他打断了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.sleep(100);
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
