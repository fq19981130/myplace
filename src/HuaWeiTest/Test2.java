package src.HuaWeiTest;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * */
public class Test2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        char c = sc.nextLine().toLowerCase().charAt(0);
        System.out.println(nums(str,c));
    }

    public static int nums(String str,char c){
        int i = 0;
        char[] chars = str.toCharArray();
        for(char ch:chars){
            if(c == ch ){
                i++;
            }
        }
        return i;
    }
}