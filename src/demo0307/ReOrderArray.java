package demo0307;

import java.util.ArrayList;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 */
public class ReOrderArray {
    public static void reOrderArray(int[]array){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<array.length;i++) {
            if(array[i]/2!=0) {
                //如果为奇数
                list.add(array[i]);
            }
        }
        for(int i=0;i<array.length;i++) {
            if(array[i]/2==0) {
                //如果为偶数
                list.add(array[i]);
            }
        }
        System.out.println(list.toArray());
    }
}
