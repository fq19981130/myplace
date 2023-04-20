package src.com.concurrency2.Obdesign;

import java.util.List;

public class ThreadLifeCycleObserver implements LifeCycleListener{

    //加锁
    private final Object LOCK = new Object();

    //批量查询
    public void concurrentQuery(List<String> ids){
        if (null == ids || ids.isEmpty()){
            return;
        }
        ids.stream().forEach(id-> new Thread(new ObserverRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                    System.out.println("query for the id:" +id);
                    Thread.sleep(1000L);
                    int x = 1/0;
                    notifyChange(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                }catch (Exception e){
                    notifyChange(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),e));
                }
            }
        },id).start());//启动
    }
    @Override
    public void onEvent(ObserverRunnable.RunnableEvent event) {
        synchronized (LOCK){
            System.out.println("The Runnable ["+event.getThread().getName()+"] data changed and state is ["+event.getState()+"] ");
            if (null!=event.getCause()){
                System.out.println("The runnable ["+ event.getThread().getName() +"] process failed");
                event.getCause().printStackTrace();
            }
        }
    }
}
