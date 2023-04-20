package src.com.concurrency;

public  class TemplateMethod {

    public final void println(String message){

        System.out.println("###############");
        wrapPrint(message);
        System.out.println("***************");
    }

    protected  void wrapPrint(String message){

    }

    public static void main(String[] args) {

        TemplateMethod t1 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*"+message+"*");
            }
        };
        t1.println("Hello Thread");

        TemplateMethod t2 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+"+message+"+");
            }
        };
        t2.println("Hello Thread2");
    }
}
