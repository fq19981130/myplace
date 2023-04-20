package src.LeedCodeStudy;


import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    public int minimumDeletions(String s) {
        Scanner scan = new Scanner(System.in);
        TreeSet set = new TreeSet();
        char j = scan.next().toLowerCase().charAt(0);
        int leftb = 0, righta = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                righta++;
            }
        }
        int res = righta;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                righta--;
            } else {
                leftb++;
            }
            res = Math.min(res, leftb + righta);
        }
        return res;
    }
}
