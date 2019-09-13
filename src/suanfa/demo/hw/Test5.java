package suanfa.demo.hw;

import java.util.Scanner;
import java.util.TreeMap;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int num = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < num; i++) {
                String[] strs = sc.nextLine().split(" ");
                if (map.containsKey(Integer.parseInt(strs[0]))) {
                    map.put(Integer.parseInt(strs[0]), map.get(Integer.parseInt(strs[0])) + Integer.parseInt(strs[1]));
                } else {
                    map.put(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
                }
            }
            for (Integer key : map.keySet()) {
                System.out.print(key + " " + map.get(key));
                System.out.println();
            }
        }
    }
}
