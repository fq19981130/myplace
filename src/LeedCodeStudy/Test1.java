package src.LeedCodeStudy;

import java.util.*;

public class Test1{
    //定义map容器存储按键对应数字字符的容器
    private static Map<String,String> map = new HashMap<>();
    //静态初始化、加载map容器
    static{
        map.put("1","1");
        map.put("abc","2");
        map.put("def","3");
        map.put("ghi","4");
        map.put("jkl","5");
        map.put("mno","6");
        map.put("pqrs","7");
        map.put("tuv","8");
        map.put("wxyz","9");
        map.put("0","0");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            //构造buffer容器存储转换后的字符串
            StringBuffer buffer = new StringBuffer();
            for(char c : chars){
                //如果是正整数则不需要进行加密
                if(c>='0'&& c<='9'){
                    buffer.append(c);
                }else if(c>='A'&& c<='Y'){ //如果是A~Y的大写字母则需要将其+32位转换成小写再向后移1位
                    char newChar = (char)(c+32+1);
                    buffer.append(newChar);
                }else if(c=='Z'){ //如果是Z则加密成a
                    buffer.append("a");
                }else{
                    //去除map容器中的key与字符进行校验并加密
                    Set<String> keys = map.keySet();
                    for(String k : keys){
                        if(k.contains(String.valueOf(c)))
                            buffer.append(map.get(k));
                    }
                }
            }
            System.out.print(buffer.toString());
        }
    }
}
