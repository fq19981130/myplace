package src.com.concurrency2.single;
//volatile能够保证内存可见性，数据一致性；单例、性能、懒加载都能保证
public class SingletonObject5 {

    private static volatile SingletonObject5 instance;
    //构造方法
    private SingletonObject5(){
        //empty
    }
    //double check
    public synchronized static SingletonObject5 getInstance(){

        if (null == instance){
            synchronized (SingletonObject4.class){
                if (null == instance)
                    instance = new SingletonObject5();
            }
        }
//        if (null == instance)
//            instance = new SingletonObject4();

        return SingletonObject5.instance;
    }
}
