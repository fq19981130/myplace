package src.com.concurrency;
/**
 * 创建线程之后在没有.start之前还不是一个线程，start之后才算创建了一个线程
 * */
public class TryConcurrency {
    public static void main(String[] args) {
//        readFromDateBase();
//        writeDataToFile();
        new Thread("Read-Thread") {
            @Override
            public void run() {
                //验证new thread也会创建一个线程状态
                println(Thread.currentThread().getName());
                readFromDateBase();
            }
        }.start();
        new Thread("Write-Thread") {
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();
    }
//        Thread t1 = new Thread("Custumer-Thread") {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    println("Task 1->" + i);
//                    try {
//                        Thread.sleep(1000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };

        //t1.start();
//        for (int j = 0; j < 1000; j++) {
//            println("Task 2->"+j);
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    public static void readFromDateBase(){
        //read date from database and handle it
        try {
            println("Begin read data from db.");
            Thread.sleep(2000*10L);
            println("read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    public static void writeDataToFile(){
        try {
            println("Begin write data from file.");
            Thread.sleep(1000*10L);
            println("write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }


    public static void println(String message){

        System.out.println(message);
    }
}
