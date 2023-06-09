package src.com.concurrency.PC;

import javax.swing.text.html.Option;
import java.util.*;

public class CaptureService {

    final static private LinkedList<Contorl> CONTROLS = new LinkedList<>();

    private final static int MAX_WORKER = 5;

    public static void main(String[] args) {

        List<Thread> worker = new ArrayList<>();

        Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10").stream()
                .map(CaptureService::createCaptureThread)
                .forEach(t ->{
                    t.start();
                    worker.add(t);
                        });
        worker.stream().forEach(t ->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("All of capture work finished").ifPresent(System.out::println);
    }

    public static Thread createCaptureThread(String name){
        return new Thread(() ->{
            Optional.of("The worker ["+Thread.currentThread().getName()+"] begin capture data")
                    .ifPresent(System.out::println);
            synchronized (CONTROLS){
                while (CONTROLS.size() > MAX_WORKER ){
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(new Contorl());
            }

            Optional.of("The worker ["+Thread.currentThread().getName()+"] is working...")
                    .ifPresent(System.out::println);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (CONTROLS){
                Optional.of("The worker ["+Thread.currentThread().getName()+"] END capture data;")
                        .ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        },name);
    }

    public static class Contorl{

    }
}
