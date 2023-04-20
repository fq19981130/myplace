package src.HuaWeiTest;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 数据范围：1-2^31-1
 * */
public class Test5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numStr = in.nextLine();
        char[] arr = numStr.toCharArray();
        int result = 0;
        for (int i = arr.length - 1; i > 1; i--) {
            int point;
            if (arr[i] >= '0' && arr[i] <= '9') {
                point = arr[i] - '0';
            } else {
                point = arr[i] - 'A' + 10;
            }
            result += (point * Math.pow(16, arr.length - 1 - i));
        }
        System.out.println(result);
    }
}
