package src.com.ThreadStudy;

/**静态代理模式：
 *  1、真实对象和代理对象都要实现同一个接口
 *  2、代理对象要代理真实角色
 *
 *  优点：
 *      代理对象可以做很多真实对象做不了的事情
 *      真实对象可以专注的做自己的事情
 *  */
public class StaticProxy {
    public static void main(String[] args) {
        //你要结婚
        You you = new You();

        new Thread(() ->System.out.println("我是你爹")).start();

        new WeddiongCompany(new You()).HappyMarry();
    }
}

interface Marry{
    void HappyMarry();

}
//真实角色
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("结婚了");
    }
}
//代理角色
class WeddiongCompany implements Marry{

    //代理谁--真实角色
    private Marry target;

    public WeddiongCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        //这个是真实对象
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚之前布置现场");
    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }
}