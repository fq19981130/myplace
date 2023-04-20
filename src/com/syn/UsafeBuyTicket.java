package src.com.syn;

/**不安全的买票
 * 有负数票而且同一张票被几个人买走
*/
public class UsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"我").start();
        new Thread(station,"黄牛党").start();
        new Thread(station,"联合票务").start();
    }
}

class BuyTicket implements Runnable{

    //票
    private int ticketNums = 100;
    //外部停止方式
    boolean flag = true;
    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronized 同步方法，锁的是this
    public synchronized void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums <=0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}
