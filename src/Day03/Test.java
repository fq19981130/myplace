package src.Day03;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 判断一个字符是不是Bigdecimal类型，如果是则四舍五入只取两位小数
 * */
public class Test {
    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal("1.98764432");
        System.out.println(decimal);
        BigDecimal setScale = decimal.setScale(2,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(setScale);

        BigDecimal setScale1 = decimal.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale1);
    }

}
