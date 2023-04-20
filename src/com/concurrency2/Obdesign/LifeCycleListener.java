package src.com.concurrency2.Obdesign;

public interface LifeCycleListener {

    void onEvent(ObserverRunnable.RunnableEvent event);
}
