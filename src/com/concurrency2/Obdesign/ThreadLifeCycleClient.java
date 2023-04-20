package src.com.concurrency2.Obdesign;

import java.util.Arrays;

public class ThreadLifeCycleClient {

    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("T1","T2"));
    }
}
