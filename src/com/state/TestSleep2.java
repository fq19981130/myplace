package src.com.state;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class TestSleep2 {
//    public static void main(String[] args) {
//        try {
//            tenDown();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
    //打印当前系统时间
    public static void main(String[] args) {
        //获取系统当前时间
        Date startTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                //更新时间
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num = 100;

        while(true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num == 0){
                break;
            }
        }
    }

}
