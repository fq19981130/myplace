package src.com.senior;

//测试生产者消费者模型-->利用缓冲区解决：管程法
//四个对象：生产者、消费者、产品、缓冲区
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Comsumer(container).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container){
        this.container = container;
    }
    //生产
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}
//消费者
class Comsumer extends Thread{
    SynContainer container;

    public Comsumer(SynContainer container){
        this.container = container;
    }
    //消费
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->"+container.pop().id+"只鸡");
        }
    }
}
//产品
class Chicken{
    //产品编号
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    Chicken [] chickens=new Chicken[10];
    int count=0;
    public synchronized void push(Chicken chicken) {
        while (count == chickens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        while (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}
