package src.com.thread;

//多个线程互相拥有对方资源导致形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup girl1 = new Makeup(0,"小花");
        Makeup girl2 = new Makeup(1,"小红");

        girl1.start();
        girl2.start();
    }
}
//口红
class Lipstick{

}
//镜子
class Mirror{

}
class Makeup extends Thread {

    //需要的资源只有一份，用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    //选择
    int choic;
    //使用化妆品的人
    String girlname;

    Makeup(int choic, String girlname) {
        this.choic = choic;
        this.girlname = girlname;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    public void makeup() throws InterruptedException {
        if (choic == 0) {
            //获得口红的锁
            synchronized (lipstick) {
                System.out.println(this.girlname + "获得口红的锁");
                Thread.sleep(1000);
            }
            //一秒钟后想获得镜子
            synchronized (mirror) {
                System.out.println(this.girlname + "获得镜子的锁");
            }
        } else {
            //获得口红的锁
            synchronized (mirror) {
                System.out.println(this.girlname + "获得镜子的锁");
                Thread.sleep(2000);
            }
            //一秒钟后想获得镜子
            synchronized (lipstick) {
                System.out.println(this.girlname + "获得口红的锁");
            }
        }
    }
}
