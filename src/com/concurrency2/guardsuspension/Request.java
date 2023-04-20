package src.com.concurrency2.guardsuspension;

public class Request {

    final private String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
