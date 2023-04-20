package src.com.concurrency.ThreadPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleThreadPool extends Thread{

    private  int size;

    private final int queuesize;

    private final static int DEFAULT_SIZE = 10;

    //定义最大线程队列数
    private static volatile int DEFAULT_TASK_QUEUE_SIZE = 2000;
    //定义自增
    private static volatile int seq = 0;

    //名字加前缀
    private final static String THREAD_PREFIX = "Simple_Thread_Pool:";

    //定义group
    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    //任务队列
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    //存放线程
    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    //定义拒绝策略
    private final   DiscardPolicy discardPolicy;
    public final static DiscardPolicy DEFAULT_DISTCARD_POLICY = () -> {
        throw new DiscardException("Discard this Task.");
    };

    private volatile boolean destory = false;

    //定义最小数
    private int min;
    //定义最大数
    private int max;
    //定义状态
    private int active;



    public SimpleThreadPool() {
        this(4,8,12, DEFAULT_TASK_QUEUE_SIZE, DEFAULT_DISTCARD_POLICY);
    }
    public SimpleThreadPool(int min, int max, int active,int queuesize,DiscardPolicy discardPolicy){
        this.min = min;
        this.max = max;
        this.active = active;
        this.size = size;
        this.queuesize = queuesize;
        this.discardPolicy = discardPolicy;
        init();
    }
    private void init(){//初始化
        for (int i = 0; i < this.size; i++) {
            createWorkTask();
        }
        this.min = min;
        this.start();
    }
    //对外接口
    public void submit(Runnable runnable){

        if (destory)
            throw  new IllegalStateException("The thread pool already destory and not allow submit task.");

        synchronized (TASK_QUEUE){
            if (TASK_QUEUE.size() > queuesize){
                discardPolicy.discard();
            }
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();//通知
        }
    }
    @Override
    public void run(){
        while (!destory){
            System.out.printf("Pool#min:%d,Active:%d,Current:%d,QueueSize:%d\n",
                    this.active,this.min,this.max,this.size,TASK_QUEUE.size());
            try {
                Thread.sleep(5_000L);
                //扩线程 start
                if (TASK_QUEUE.size() > active && size <active){
                    for (int i = size;i < active; i++){
                        createWorkTask();
                    }
                    System.out.println("The pool incremented to active.");
                    size = active;
                }else if (TASK_QUEUE.size() > max && size <max){
                    for (int i = size;i < active; i++){
                        createWorkTask();
                    }
                    System.out.println("The pool incremented to max.");
                    size = max;
                }
                //扩线程 end
                //缩减线程start
                if (TASK_QUEUE.isEmpty()&& size > active){
                    synchronized (TASK_QUEUE){
                        int releaseSize = size - active;
                        for (Iterator<WorkerTask> it = THREAD_QUEUE.iterator();it.hasNext();){
                            if (releaseSize <= 0)
                                break;

                                WorkerTask task = it.next();
                                task.close();
                                task.interrupt();
                                it.remove();
                                releaseSize--;
                            }
                        }
                    }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void createWorkTask(){//创建线程
        WorkerTask task = new WorkerTask(GROUP,THREAD_PREFIX+(seq++));
        task.start();
        THREAD_QUEUE.add(task);
    }


    //停止线程
    public void shutdown() throws InterruptedException {
        while (!TASK_QUEUE.isEmpty()){
            Thread.sleep(50);
        }
        int initVal = THREAD_QUEUE.size();
        while (initVal > 0){
            for (WorkerTask task:THREAD_QUEUE){
                if (task.getTaskState() == TaskState.BLOCKED){
                    task.interrupt();
                    task.close();
                    initVal--;
                }else {
                    Thread.sleep(10);
                }
            }
        }
        this.destory = true;
        System.out.println("This Thread pool disposed");
    }

    public int getSize() {
        return size;
    }


    public int getQueuesize() {
        return queuesize;
    }

    public boolean isDestory(){
        return this.destory;
    }

    private enum TaskState{
        FREE,ROUNNING,BLOCKED,DEAD
    }

    //定义异常
    public static class DiscardException extends RuntimeException{

        public DiscardException(String message){
            super(message);
        }

    }

    //
    public interface DiscardPolicy{
         void discard() throws DiscardException;
    }

    private static class WorkerTask extends Thread{

        private volatile TaskState taskState = TaskState.FREE;

        public TaskState getTaskState(){
            return this.taskState;
        }

        public WorkerTask(ThreadGroup group,String name){
            super(group,name);
        }

        public void run(){
            OUTER:
            while (this.taskState != TaskState.DEAD){
                Runnable runnable;
                synchronized (TASK_QUEUE){
                    while (TASK_QUEUE.isEmpty()){
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Close:");
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }
                if (runnable != null){
                    taskState = TaskState.ROUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }
        public void close(){
            this.taskState = TaskState.DEAD;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool threadPool = new SimpleThreadPool();
        for (int i = 0; i < 40; i++) {
            threadPool.submit(()->{
                System.out.println("The runnable  be service by "+Thread.currentThread()+" start");
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The runnable  be service by"+Thread.currentThread()+" finish.");

        });
        }
        Thread.sleep(10000);
        threadPool.shutdown();
        //提交了重新submit会报异常
        //threadPool.submit(()-> System.out.println("==============="));
//        IntStream.rangeClosed(0,40)
//                .forEach(i->{
//                    threadPool.submit(()->{
//                        System.out.println("The runnable "+i+" be service by "+Thread.currentThread()+" start");
//                        try {
//                            Thread.sleep(10_000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println("The runnable "+i+" be service by"+Thread.currentThread()+" finish.");
//                    });
//                });
    }

}
