package suanfa.demo.hw;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            if(str.length()%8!=0){
                str=str+"00000000";
            }
            while(str.length()>=8){
                System.out.println(str.substring(0,8));
                str=str.substring(8);
            }
        }
    }
}
