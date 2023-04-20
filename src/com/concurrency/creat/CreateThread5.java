package src.com.concurrency.creat;

public class CreateThread5 {

    private static int counter = 1;
    public static void main(String[] args) {

        try {
            for (int i =0; i < Integer.MAX_VALUE;i++){
                counter++;
                 new Thread(()-> {
                        byte[] bytes = new byte[1024*1024*2];
                        while (true) {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                }
                ).start();
            }
        }catch (Error e){

        }
        System.out.println("Total create thread nums =>"+counter);
    }
}
