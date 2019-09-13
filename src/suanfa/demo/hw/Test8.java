package suanfa.demo.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int len=Integer.parseInt(sc.nextLine());
            String[]strs=new String[len];
            for(int i=0;i<len;i++){
                strs[i]=sc.nextLine();
            }
            Arrays.sort(strs);
            for(String str:strs){
                System.out.println(str);
            }
        }
    }
}