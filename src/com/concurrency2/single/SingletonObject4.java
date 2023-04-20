package src.com.concurrency2.single;
//用double check方式加载可能会导致栈内存异常
public class SingletonObject4 {
    private static  SingletonObject4 instance;
    //构造方法
    private SingletonObject4(){
        //empty
    }
    //double check
    public synchronized static SingletonObject4 getInstance(){

        if (null == instance){
            synchronized (SingletonObject4.class){
                if (null == instance)
                    instance = new SingletonObject4();
            }
        }
//        if (null == instance)
//            instance = new SingletonObject4();

        return SingletonObject4.instance;
    }
}
