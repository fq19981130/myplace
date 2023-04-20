package src.com.lambda;

public class TestLambda2 {

    static class Love implements  Ilove{
        @Override
        public void love(int a) {
            System.out.println("I love study-->"+a);
        }
    }

    public static void main(String[] args) {
        //1、lambda简化
        Ilove love = (int a)->{
            System.out.println("i love study"+a);
        };
        //2、去掉参数类型
//        love = (a)->{
//            System.out.println("i love study"+ a);
//        };
        //简化括号
//        love = a -> {
//            System.out.println("i love study"+a);
//        };
        //简化花括号
        love = a -> System.out.println("i love study"+a);

        love.love(522);

        class Love implements  Ilove{
            @Override
            public void love(int a) {
                System.out.println("I love study-->"+a);
            }
        }
        //Ilove love = new Love();
        //love.love(2);
    }
}

interface Ilove{
    void love(int a);
}
class Love implements  Ilove{
    @Override
    public void love(int a) {
        System.out.println("I love study-->"+a);
    }
}
//总结：lambda表达式只能在只有一行代码的情况下才能简化成一行，如果有多行，应该用代码块儿包裹，
// 即前提是函数式接口，多个参数可以去掉参数类型但是应当加上括号，而且去掉时应当都去掉
