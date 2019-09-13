package HUAWEI;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String,Integer>map=new LinkedHashMap<>();
        while(sc.hasNext()){
            String path=sc.next();//路径
            int index=path.lastIndexOf('\\');
            String filename=index<0?path:path.substring(index+1);
            int linenum=sc.nextInt();//行号
            String key=filename+" "+linenum;//文件名加行号
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);//如果集合中已经存在相同的记录，那么记录加一
            }else {
                map.put(key,1);
            }
        }
        sc.close();
        //按照记录的数量记录错误信息
        List<Map.Entry<String,Integer>>lists=new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
        //将记录按从多到少排序，即降序
        Collections.sort(lists, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //如果记录数相同，那么位置不变
                return (o2.getValue()-o1.getValue())==0?(o1.getValue()-o2.getValue()):(o2.getValue()-o1.getValue());
            }
        });
        int count=0;
        for(Map.Entry<String,Integer>list:lists) {
            if (count < 8) {
                String[] str = list.getKey().split(" ");//将文件名和行号分离成为一个数组的两个元素
                String k = str[0].length() > 16 ? str[0].substring(str[0].length() - 16) : str[0];
                String n = str[1];
                System.out.println(k + " " + n + " " + list.getValue());
            } else {
                break;
            }
            count++;
        }
    }
}
/*
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String, Integer> map=new LinkedHashMap<String, Integer>();
        while(sc.hasNext()){
            String str=sc.next();
            int linenum=sc.nextInt();
            String[] arr=str.split("\\\\");  //根据\切割
            String s=arr[arr.length-1];
            if(s.length()>16)  //截取
                s=s.substring(s.length()-16);
            String key=s+" "+linenum;
            int value=1;
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else {
                map.put(key, value);
            }
        }
        int count=0;
        for(String string:map.keySet()){
            count++;
            if(count>(map.keySet().size()-8)) //输出最后八个记录
                System.out.println(string+" "+map.get(string));
        }
    }
}
 */
