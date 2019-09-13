package suanfa.demo.hw;
import java.util.*;
//例： 输入 long time no see 输出 ltns 即输出每个单词的第一个字母
public class Test17{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(delW(str));
    }

    public static String delW(String str){
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i].charAt(0));
        }
        return sb.toString();
    }
}