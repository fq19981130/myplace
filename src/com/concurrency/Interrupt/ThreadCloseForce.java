package src.com.concurrency.Interrupt;

public class ThreadCloseForce {

    public static void main(String[] args) {

        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();

        service.excute(() ->{
            //load a very heavy resouce.
            //while (true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //}
        });
        service.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
