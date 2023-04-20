package src.com.concurrency2.ThreadLocal;

import java.util.HashMap;
import java.util.Map;

public abstract class Simulator<T> {

    private final Map<Thread,T> storage = new HashMap<>();

    public void set(T t){
        synchronized (this){
            Thread key = Thread.currentThread();
            storage.put(key,t);
        }
    }
    public T get(){
        synchronized (this){
            Thread key = Thread.currentThread();
            T value =  storage.get(key);
            if (value == null){
                return initiaValue();
            }
            return value;
        }
    }

    private T initiaValue() {
        return null;
    }

    public abstract String initialValue();
}
