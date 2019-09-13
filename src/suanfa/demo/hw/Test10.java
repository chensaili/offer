package suanfa.demo.hw;
import java.util.Scanner;
public class Test10 {
    public static void main(String[] aStrings) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String[]input=sc.nextLine().split(";");
            System.out.println(input.length);
            int x=0;
            int y=0;
            for(int i=0;i<input.length-1;i++){
                System.out.println(input[i].matches("[ADWS][0-9]{1,2}"));
                System.out.println(input[i].substring(1));
                if(input[i].matches("[ADWS][0-9]{1,2}")){
                    String start=input[i].substring(0,1);
                    int num=Integer.parseInt(input[i].substring(1));
                    if(start.equals("A")){
                        x=x-num;
                    }else if(start.equals("D")){
                        x=x+num;
                    }else if(start.equals("S")){
                        y=y-num;
                    }else{
                        y=y+num;
                    }
                }
            }
            System.out.println(x+";"+y);
        }
    }
}