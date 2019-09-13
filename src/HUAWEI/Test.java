package HUAWEI;
//求字符串中最长回文长度
import java.util.*;
public class Test{
    public static int max=0;
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();//输入字符串
            char[]chs=input.toCharArray();
            int max=0;
            for(int i=1;i<chs.length;i++){
                //偶数长度的回文
                int start=i-1;
                int end=i;
                while(start>=0&&end<chs.length&&chs[start]==chs[end]){
                    if(max<end-start+1){
                        max=end-start+1;
                    }
                    end++;
                    start--;
                }
                //奇数长度的回文
                start=i-1;
                end=i+1;
                while(start>=0&&end<chs.length&&chs[start]==chs[end]){
                    if(max<end-start+1){
                        max=end-start+1;
                    }
                    end++;
                    start--;
                }
            }
            System.out.println(max);
        }
    }
}
