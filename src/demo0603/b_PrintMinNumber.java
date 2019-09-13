package demo0603;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class b_PrintMinNumber {
    public static void main(String[] args) {
        int[]numbers=new int[]{31,32,321};
        String res=printMinNumber(numbers);
        System.out.println(res);
    }
    public static String printMinNumber(int[]numbers) {
        if(numbers==null||numbers.length==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        int len=numbers.length;
        //1.将数组里的整型转为字符串
        String[]str=new String[len];
        for(int i=0;i<len;i++){
            str[i]=String.valueOf(numbers[i]);
        }
        //2.对数组进行排序
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1=o1+o2;
                String str2=o2+o1;
                return str1.compareTo(str2);
            }
        });
        //打印排序后的字符串数组
        for(String s:str) {
            System.out.println(s);
        }
        //将排序好的字符串拼接
        for(int i=0;i<len;i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
