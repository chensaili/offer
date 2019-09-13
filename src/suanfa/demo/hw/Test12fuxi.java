package suanfa.demo.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test12fuxi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String,Integer>map=new HashMap<>();
        while(sc.hasNext()){
            String[]strs=sc.nextLine().split("\\\\");
            int linenum=sc.nextInt();
            String file=strs[strs.length-1];
            if(file.length()>16){
                file=file.substring(file.length()-16);
            }
            String key=file+" "+linenum;
            int value=1;
            if(!map.containsKey(key)){
                map.put(key,value);
            }else {
                map.put(key,map.get(key)+1);
            }
            int count=0;
            for(String str:map.keySet()){
                count++;
                if(count>(map.keySet().size()-8)){
                    System.out.println(str+" "+map.get(str));
                }
            }
        }
    }
}
