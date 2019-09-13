package dynamic;

import java.util.Collection;
import java.util.Scanner;

/**
 * 利用动态规划求最长递增序列
 */
public class Demo6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            char[]chs=str.toCharArray();
            System.out.println(getMax(chs));;
        }
    }
    public static int getMax(char[] chs){
        int[]longest=new int[chs.length];//最长递增序列
        //每一个数自己都算一个
        for(int i=0;i<chs.length;i++){
            longest[i]=1;
        }
        //关键
        for(int i=1;i<chs.length;i++){
            for(int j=0;j<i;j++){
                if(chs[i]>chs[j]&&longest[i]<longest[j]+1){//longest[i]<longest[j]+1不要忘记
                    longest[i]=longest[j]+1;
                }
            }
        }
        //从最长递增序列中取得最大的那个数
        int max=0;
        for(int j=0;j<chs.length;j++){
            if(longest[j]>max){
                max=longest[j];
            }
        }
        return max;
    }
}
