package suanfa.demo.hw;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test2 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
       while (sc.hasNext()){
           String num=sc.nextLine();
           TreeSet<Integer> set=new TreeSet<Integer>();
           for(int i=0;i<Integer.parseInt(num);i++){
               set.add(Integer.parseInt(sc.nextLine()));
           }
           Iterator iterator=set.iterator();
           while(iterator.hasNext()){
               System.out.println(iterator.next());
           }
       }
    }
}
