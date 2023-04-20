package src.com.concurrency2.Obdesign;

public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Boinary String:"+Integer.toBinaryString(subject.getState()));
    }
}
