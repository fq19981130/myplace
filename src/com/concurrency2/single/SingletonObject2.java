package src.com.concurrency2.single;
//实现了懒加载但是由于创建了多个示例因此线程也许不安全
public class SingletonObject2 {

    private static  SingletonObject2 instance;
    //构造方法
    private SingletonObject2(){
        //empty
    }
    public static SingletonObject2 getInstance(){

        if (null == instance)
            instance = new SingletonObject2();

        return SingletonObject2.instance;
    }
}
