package src.com.state;

import src.com.ThreadStudy.TestThread4;

//模拟网络延时:放大问题发生性
public class TestSleep implements Runnable{

    //票数
    private int tacketNubmer = 500;
    @Override
    public void run() {
        while (true){
            if (tacketNubmer <= 0 ){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+tacketNubmer--+"票");
        }
    }

    public static void main(String[] args) {

        TestSleep ticket = new TestSleep();

        new Thread(ticket,"明明").start();
        new Thread(ticket,"莽子").start();
        new Thread(ticket,"基友").start();
        new Thread(ticket,"黑娃").start();
    }
}
