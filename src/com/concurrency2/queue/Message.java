package src.com.concurrency2.queue;

public class Message {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Message(String data) {
        this.data = data;
    }
}
