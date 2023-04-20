package src.com.concurrency2.guardsuspension;

public class SuspensionClient {

    public static void main(String[] args) throws InterruptedException {

        final RequestQueue queue = new RequestQueue();
        ServerThread serverThread = new ServerThread(queue);
        new ClientThread(queue,"Alex").start();
        serverThread.start();
        //serverThread.join();

        Thread.sleep(10000);

        serverThread.close();

    }
}
