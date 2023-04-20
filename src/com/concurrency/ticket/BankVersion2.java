package src.com.concurrency.ticket;

public class BankVersion2 {
    public static void main(String[] args) {
        final SynchronizedRunnable ticketWindow = new SynchronizedRunnable();

        Thread windowThread = new Thread(ticketWindow,"一号窗口");
        Thread windowThread2 = new Thread(ticketWindow,"二号窗口");
        Thread windowThread3 = new Thread(ticketWindow,"三号窗口");

        windowThread.start();
        windowThread2.start();
        windowThread3.start();
    }
}
