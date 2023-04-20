package src.com.concurrency2.Sdesign;
//多个线程访问统一资源
public class Client {

    public static void main(String[] args) {
        Gate gate = new Gate();
        User zkg = new User("baobao","beijing",gate);
        User wzy = new User("shangLao","shanghai",gate);
        User cmm = new User("guangLao","guangZhou",gate);

        zkg.start();
        wzy.start();
        cmm.start();
    }
}
