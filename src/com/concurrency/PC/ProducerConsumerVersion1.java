package src.com.concurrency.PC;

public class ProducerConsumerVersion1 {

    public static void main(String[] args) {

        ProducerConsumerVersion1 pc = new ProducerConsumerVersion1();

        new Thread("P"){
            @Override
            public void run() {
                while (true)
                    pc.produce();
            }
        }.start();

        new Thread("P"){
            @Override
            public void run() {
                pc.consume();
            }
        }.start();
    }
    private int i = 1;

    final private Object LOCK = new Object();

    private void produce(){
        synchronized (LOCK){
            System.out.println("P->"+(i++));
        }
    }
    private void consume(){
        synchronized (LOCK){
            System.out.println("C ->" + i);
        }
    }

}
