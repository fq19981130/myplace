package src.Day04;
//写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1 = scanner.nextLine();
        s = s.toLowerCase();
        s1 = s1.toLowerCase();
        int i = 0;
        Integer a;
        while (s.indexOf(s1) != -1) {
            i++;
            s = s.substring(s.indexOf(s1) + 1, s.length());

        }
        System.out.println(i);
    }
}