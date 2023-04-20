package src.com.concurrency2.single;
//饿汉式方式加载因此没办法懒加载
public class SingletonObject {
    /**
     * con't lazy load
     * */
    private static final SingletonObject instance = new SingletonObject();
    //构造方法
    private SingletonObject(){
        //empty
    }
    public static SingletonObject getInstance(){
        return instance;
    }
}
