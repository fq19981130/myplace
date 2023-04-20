package src.Day02;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 求两个长长整型的数据的和并输出，例如输入1233333333333333 。。。 3111111111111111111111111.。。。，则输出
 * */
public class Text2 {
    public static void main(String[] args) {


        Text2 c = new Text2();


        System.out.println("请输入两个长整形数：");
        Scanner s = new Scanner(System.in);

        long n = s.nextLong();
        String str1 = "" + n;
        BigDecimal bi1 = new BigDecimal(str1);

        long m = s.nextLong();
        String str2 = "" + m;
        BigDecimal bi2 = new BigDecimal(str2);

        BigDecimal bi3 = bi1.add(bi2);

        // System.out.println(c.add("1234567890123456789043876945","123456781098765432112345622232323232323"));

        System.out.println("bi3=" + bi3);
    }

    public String add(String a, String b) {

        if (a.length() > b.length()) {

            return adds(a.trim(), b.trim());
        } else {

            return adds(b.trim(), a.trim());
        }
    }

    private String adds(String a, String b) {
        int tmp = 0;
        int t = 0;

        char[] nc = new char[a.length()];

        for (int i = a.length() - 1, j = i - (a.length() - b.length()); i >= 0; i--) {

            if (a.charAt(i) > 47 && a.charAt(i) < 58) {

                t = tmp + (int) a.charAt(i) - 48;

            } else {

                throw new FormatException(a + "第" + (i + 1) + "个字符不是数字");

            }

            if (j >= 0) {

                if (b.charAt(j) > 47 && b.charAt(j) < 58) {

                    t = t + (int) b.charAt(j) - 48;

                } else {

                    throw new FormatException(b + "第" + (j + 1) + "个字符不是数字");

                }

            }
            tmp = t / 10;
            nc[i] = (char) (t % 10 + 48);
            j--;
        }
        if (tmp > 0) {
            return tmp + new String(nc);
        } else {
            return new String(nc);
        }

    }

    class FormatException extends RuntimeException {
        public FormatException(String string) {
            super(string);
        }

    }


}
