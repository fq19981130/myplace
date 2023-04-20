package src.com.state;
//观察测试线程状态
public class TestState {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("~~~~~~~~~~~");
        });


        //观察状态
        Thread.State state = thread.getState();
        //NEW
        System.out.println(state);

        //观察启动后
        //启动线程
        thread.start();
        state = thread.getState();
        //Run
        System.out.println(state);
        //只要线程不终止就一直输出状态
        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            //更新线程状态
            state = thread.getState();
            //输出状态
            System.out.println(state);
        }

        //thread.start();
    }
}
