package src.LeedCodeStudy;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ipandmark = new String[2];
        String[] ipaddr = new String[4];
        //定义初始参数errIporMark privateIp
        int A = 0,B = 0,C = 0,D =0,E = 0,errIporMark = 0,privateIp = 0;
        while (in.hasNextLine()) {
            //通过~分割IP地址和mark地址
            ipandmark = in.nextLine().split("\\~");
            if ("end".equals(ipandmark[0])) {
                break;
            }
            ipaddr = ipandmark[0].split("\\.");//~前面的是IP地址
            //忽略0和127开头的参数
            if ("0".equals(ipaddr[0]) || "127".equals(ipaddr[0])) {
                continue;//直接跳过
            }
            if (!isValidMask(ipandmark[1])) {
                errIporMark++;
                //这里直接输出错误的子网掩码
            } else {
                if (!isValidIp(ipandmark[0])) {
                    errIporMark++;
                } else {
                    if (Integer.parseInt(ipaddr[0]) >= 1 &&
                            Integer.parseInt(ipaddr[0]) <= 126)
                        if (Integer.parseInt(ipaddr[0]) == 10) {
                            privateIp++;
                            A++;
                        } else {
                            A++;
                        }
                }
                if (Integer.parseInt(ipaddr[0]) >= 128 &&
                        Integer.parseInt(ipaddr[0]) <= 191) {
                    if (Integer.parseInt(ipaddr[0]) == 172 &&
                            (Integer.parseInt(ipaddr[1]) >= 16 &&
                                    Integer.parseInt(ipaddr[1]) <= 31)) {
                        privateIp++;
                        B++;
                    } else {
                        B++;
                    }
                }
                if (Integer.parseInt(ipaddr[0]) >= 192 &&
                        Integer.parseInt(ipaddr[0]) <= 223) {
                    if (Integer.parseInt(ipaddr[0]) == 192 &&
                            Integer.parseInt(ipaddr[0]) == 168) {
                        privateIp++;
                        C++;
                    } else {
                        C++;
                    }
                }
            }
            if (Integer.parseInt(ipaddr[0]) >= 224 &&
                    Integer.parseInt(ipaddr[0]) <= 239) {
                D++;
            }
            if (Integer.parseInt(ipaddr[0]) >= 240 &&
                    Integer.parseInt(ipaddr[0]) <= 255) {
                E++;
            }
        }
        System.out.println(A + " " + B + " " + C + " " + D + " " + E + " " + errIporMark + " " + privateIp);
    }
    public static boolean isValidMask(String mask) {
        if (!isValidIp(mask)) {
            return false;
        }
        String[] maskTable = mask.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maskTable.length; i++) {
            maskTable[i] = Integer.toBinaryString(Integer
                    .parseInt(maskTable[i]));
            if (maskTable[i].length() < 8) { //不足8位补齐0
                for (int j = 0; j < 8 - maskTable[i].length(); j++) {
                    sb.append("0");//补完零
                }
                sb.append(maskTable[i]);//再添加转换的2进制串
            } else {
                sb.append(
                        maskTable[i]);//刚好8位直接添加，因为之前已经判断过ip的有效性，所以不可能超过8位
            }
        }
        return sb.toString().lastIndexOf("1") < sb.toString().indexOf("0");
    }

    public  static boolean isValidIp(String ip) {
        String[] ipTable = ip.split("\\.");
        if (ipTable.length != 4) {
            return false;
        }
        for (String s : ipTable) {
            if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
                return false;
            }
        }
        return true;
    }
}