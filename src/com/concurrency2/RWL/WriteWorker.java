package src.com.concurrency2.RWL;

import java.util.Random;

public class WriteWorker extends Thread{

    private static final Random randow = new Random(System.currentTimeMillis());

    private final ShareData data;

    private final String filler;

    private int index = 0;

    public WriteWorker(ShareData data, String filler) {
        this.data = data;
        this.filler = filler;
    }
    @Override
    public void run(){
        try {
        while (true){
            char c = nextChar();
                data.write(c);
                Thread.sleep(10_00L);
                }
            }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length())
            index = 0;
        return c;
    }
}
