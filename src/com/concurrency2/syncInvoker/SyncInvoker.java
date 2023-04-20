package src.com.concurrency2.syncInvoker;
/**
 * Feture         -->代表的是未来的一个凭据
 * FetureTask     -->讲你的调用逻辑进行隔离
 * FetureService  --> 桥接Feture和FetureTask
 *
 * */
public class SyncInvoker {
    public static void main(String[] args) throws InterruptedException {
//        String result = get();
//        System.out.println(result);

        FutureService futureService = new FutureService();
        //Future<String> future =
        futureService.submit((()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        }),System.out::println);
        System.out.println("==================");
        System.out.println("do other thing.");
        Thread.sleep(1000);
        System.out.println("==================");
        //等不起
        //System.out.println(future);
    }
    private static String get() throws InterruptedException {
        Thread.sleep(100001);
        return  "FINISH";
    }
}
