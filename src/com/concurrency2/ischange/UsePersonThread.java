package src.com.concurrency2.ischange;

public class UsePersonThread extends Thread{

    private Person person;

    public UsePersonThread(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " print " + person.toString());
    }
}
