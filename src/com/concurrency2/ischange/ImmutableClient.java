package src.com.concurrency2.ischange;

import java.util.stream.IntStream;

public class ImmutableClient {

    public static void main(String[] args) {
        //共享数据
        Person person = new Person("Alex", "GuanSu");
        IntStream.range(0,15).forEach(i->
                new UsePersonThread(person).start());
    }
}
