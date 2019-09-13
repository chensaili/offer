package suanfa.demo.hw;

import java.util.*;
public class Test7{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            char[] ch=str.toCharArray();
            HashSet<Character> set=new HashSet<Character>();
            for (int i = 0; i < ch.length; i++) {
                set.add(ch[i]);
            }
            System.out.println(set.size());
        }
        sc.close();
    }
}