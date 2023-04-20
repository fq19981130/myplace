package src.Day02;

import java.math.BigDecimal;
import java.util.Scanner;
/**
 * 第一题的题目大概是输入整型数组求数组的最小数和最大数之和，例如输入1,2,3,4则输出为5，当输入只有一个数的时候，
 *  则最小数和最大数都是该数，例如只输入1，则输出为2；另外数组的长度不超过50
 * */
public class Test1 {
    public static void main(String[] args)
    {
        System.out.println("请输入数组长度1~50：");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("请输入数组：");
        Scanner sc = new Scanner(System.in);
        int []a=new int[n];

        for(int i=0;i<n;i++)

        {
            a[i] = sc.nextInt();
        }

        int max=a[0],min=a[0];//这两个一定要放到数组赋值以后不然min始终为0

        for(int j=0;j<n;j++)
        {
            if(max<a[j])
                max=a[j];

            else if(min>a[j])
                min=a[j];
        }
        System.out.println("max=" + max);
        System.out.println("min=" + min);
        int sum=min+max;
        System.out.println(sum + ",");

        s.close();
        sc.close();

    }
}

