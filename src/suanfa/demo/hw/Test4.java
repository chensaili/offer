package suanfa.demo.hw;

import java.util.Scanner;

/**
 * 任何一个正整数可以分解为多个质数的乘积
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLong()){
            long num=sc.nextLong();
            isPrime(num);
        }
    }
    public static void isPrime(long num){
        long number=num;
        while(number!=1){
            for(int i=2;i<=number;i++){
                if(number%i==0){
                    number=number/i;
                    System.out.println(i+" ");
                    break;
                }
            }
        }
    }
}
