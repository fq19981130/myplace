package src.HuaWeiTest;

import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * */
public class Test6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        long num = Long.parseLong(in.nextLine());
        int prime = 2;
        while(prime <= num){
            if(num % prime == 0){
                if(num == prime){
                    System.out.print(prime+" ");
                    break;
                }
                System.out.print(prime+" ");
                num = num/prime;
                continue;
            }else{
                prime ++;
                continue;
            }
        }
    }
}
