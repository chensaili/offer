package suanfa.demo.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        char[]input=sc.nextLine().toLowerCase().toCharArray();
        Map<Object,Integer> map=new HashMap<Object,Integer>();
        for(int i=0;i<input.length;i++){
            if(!map.containsKey(input[i])){
                map.put(input[i],1);
            }else{
                map.put(input[i],map.get(input[i])+1);
            }
        }
        char str=sc.nextLine().toLowerCase().charAt(0);
        if(map.containsKey(str)){
            System.out.print(map.get(str));
        }else{
            System.out.print(0);
        }
    }
}