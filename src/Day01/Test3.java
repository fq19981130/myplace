package src.Day01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾
 * */
public class Test3 {
    public static void main(String[] args) throws IOException{
        BufferedReader s=new BufferedReader(new InputStreamReader(System.in));
        String str=s.readLine();
        String[] arr=str.split(" ");
        System.out.println(arr[arr.length-1].length());
    }
}