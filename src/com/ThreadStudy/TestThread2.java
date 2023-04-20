//package src.com.ThreadStudy;
//
//
////练习Thread，实现多线程同步下载图片
//public class TestThread2 {
//    @Override
//    public void run(){
//        WebDownloader webDownloader = new WebDownloader();
//        webDownloader.downloader(url,name);
//        System.out.println("下载了文件名为："+name);
//    }
//
//    public static void main(String[] args) {
//        TestThread t1 = new TestThread2("",);
//        TestThread t2 = new TestThread2("",);
//        TestThread t3 = new TestThread2("",);
//
//        t1.start();
//    }
//}
//
//
////下载器
//class WebDownloader{
//    //下载方法
//    public void downloader(){
//        FileUtils.copyURLToFile(new URL(url),new File(name));
//    }
//}
