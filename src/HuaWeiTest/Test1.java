package src.HuaWeiTest;
/**
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * */
import java.util.Scanner;

public class Test1{
    public static void main(String[] args) {
        Scanner test = new Scanner(System.in);
        String t = test.nextLine();
        int i = t.length() - 1;
        int j = 0;
        while (i >= 0 && t.charAt(i) != ' '){
            j++;
            i--;
        }
        System.out.println(j);
    }
}
