package src.HuaWeiTest;

import java.util.Scanner;

/**
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * */
public class Test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        while (s.length() >= 8) {
            System.out.println(s.substring(0, 8));
            //定义数组长度
            s = s.substring(8);
        }
        if (s.length() < 8 && s.length() > 0) {
            s += "000000000";
            System.out.println(s.substring(0, 8));
        }

    }
}
