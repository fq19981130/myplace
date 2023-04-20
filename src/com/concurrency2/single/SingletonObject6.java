package src.com.concurrency2.single;

//保证线程创建懒加载且保证线程安全且效率高
//类加载过程：装载(读取class文件)->链接(赋值并且初始化static的值)->
public class SingletonObject6 {

    private SingletonObject6(){

    }
    private static class InstanceHolder{
        private final static SingletonObject6 instance = new SingletonObject6();//static只会被初始化一次
    }

    public static SingletonObject6 getInstance(){
        return InstanceHolder.instance;
    }
}
