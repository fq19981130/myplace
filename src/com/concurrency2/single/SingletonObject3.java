package src.com.concurrency2.single;
//实现了懒加载和实例但是性能不佳，因为要调用synchronized
public class SingletonObject3 {

    private static  SingletonObject3 instance;
    //构造方法
    private SingletonObject3(){
        //empty
    }
    public synchronized static SingletonObject3 getInstance(){

        if (null == instance)
            instance = new SingletonObject3();

        return SingletonObject3.instance;
    }
}
