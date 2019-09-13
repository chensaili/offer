package HUAWEI;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入，即需要写上while(sc.hasNext) ）
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            String s=str.substring(2);
            long res=Long.parseLong(s,16);//16进制转为十进制
            System.out.println(res);
        }
    }
}
