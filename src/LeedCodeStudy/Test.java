package src.LeedCodeStudy;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            int m = a.length();
            int n = b.length();
            int[][] dp = new int[m + 1][n + 1];
            int maxLength = 0;
            int maxI = 0, maxJ = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        if (dp[i][j] > maxLength) {
                            maxLength = dp[i][j];
                            maxI = i;
                            maxJ = j;
                        } else if (dp[i][j] == maxLength) {
                            if (m < n && maxI > i || n < m && maxJ > j) {
                                maxI = i;
                                maxJ = j;
                            }
                        }
                    }
                }
            }
            System.out.println(a.substring(maxI - maxLength, maxI));
        }
    }
}