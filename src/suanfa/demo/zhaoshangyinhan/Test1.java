package suanfa.demo.zhaoshangyinhan;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        while (true){
            Scanner sc=new Scanner(System.in);
            int input=sc.nextInt();
            //如果N=1，那么只有1种可能
            if(input==1){
                System.out.println(1);
            }else if(input==2){
                System.out.println(4);
            }else {
                System.out.println(1+input+input*(input-1)/2);
            }
        }
    }
}
