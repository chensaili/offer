package suanfa.demo.hw;

import java.util.ArrayList;
import java.util.Iterator;
public class Test13 {
    public static void main(String[] args) {
        ArrayList<String>array=new ArrayList<>();
        array.add("a");
        array.add("b");
        array.add("c");
        array.add("d");
        /*for(int i=0;i<array.size();i++){
            if(i==2) {
                array.remove(i);
            }
            System.out.println(array.get(i));

        }*/
        for (String item : array) {
            if ("a".equals(item)) {
                System.out.println(item);
                array.remove(item);
            }
        }

    }
}
