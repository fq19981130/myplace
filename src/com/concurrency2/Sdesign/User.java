package src.com.concurrency2.Sdesign;

public class User extends Thread{

    private final String myname;
    private final String myAddress;
    private final Gate gate;

    public User(String myname, String myAddress, Gate gate) {
        this.myname = myname;
        this.myAddress = myAddress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myname+"BEGIN");
        while (true){
            this.gate.pass(myname,myAddress);
        }
    }
}
