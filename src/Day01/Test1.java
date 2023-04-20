package src.Day01;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        for (int i = 1;i<=101;i++){
            System.out.println("请输入一个数");
            int a = new Scanner(System.in).nextInt();
            if (a < 80){
                System.out.println("你龟儿输错了");
            }
            if (a >=100 ){
                System.out.println("你还是输错了");
            }
            if(a >= 80&&a<100){
                System.out.println("开始计算");
                int b = a++;
                int c = b*5;
                System.out.println("b="+b);
                System.out.println("c="+c);

            }
        }
    }
}
