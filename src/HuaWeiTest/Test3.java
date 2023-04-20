package src.HuaWeiTest;

import java.util.Scanner;

/**
 * 明明生成了
 * �
 * N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 *
 * 数据范围：
 * 1
 * ≤
 * �
 * ≤
 * 1000
 *
 * 1≤n≤1000  ，输入的数字大小满足
 * 1
 * ≤
 * �
 * �
 * �
 * ≤
 * 500
 *
 * 1≤val≤500
 * */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] arr = new int[1001];
            for (int i = 0; i < num; i++) {
                int n = scanner.nextInt();
                arr[n] = 1;
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 1) {
                    System.out.println(i);
                }
            }
        }
    }
}
