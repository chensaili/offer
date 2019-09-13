package demo0605;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=“abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class e_LeftRotateString {
    public static void main(String[] args) {
        System.out.println(leftRotateString("XYZdef",6));
    }
    public static String leftRotateString(String str,int n){
        int len=str.length();
        if(str.length()==0){
            return "";
        }
        n=n%len;
        str+=str;
        return str.substring(n,len+n);
        /*String s1=str.substring(0,n);
        String s2=str.substring(n);
        return s2+s1;*/
    }
}
