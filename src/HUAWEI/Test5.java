package HUAWEI;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 * 请你协助明明完成“去重”与“排序”的工作
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       while(sc.hasNext()){
            int size=sc.nextInt();//输入随机整数的个数
            //利用了TreeSet的里面的元素不可重复，且默认自然排序的特点
            TreeSet<Integer>set=new TreeSet<>();
            /*//随机生成N个整数
            Random rand=new Random();
            for(int i=0;i<size;i++){
                set.add(rand.nextInt(1000)+1); //生成1-1000的随机数
            }*/
           for(int i=0;i<size;i++){
               int cur=sc.nextInt();
               set.add(cur);
           }
            for(Integer i:set){
                System.out.println(i);
            }
        }
    }
}
