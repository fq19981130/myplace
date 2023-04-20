package src.com.ThreadStudy;
/**多个线程同时操作同
 * 一个对象买票的例子
*/

/**
 * 发现问题：多个线程操作同一个资源时，数据紊乱，线程不安全
 * */
public class TestThread4 implements Runnable{

    //票数
    private int ticketNumber = 500;

    @Override
    public void run() {
        while (true){
            if (ticketNumber <= 0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNumber--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"莽子").start();
        new Thread(ticket,"基友").start();
    }
}
