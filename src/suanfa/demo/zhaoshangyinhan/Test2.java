package suanfa.demo.zhaoshangyinhan;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[]strs=sc.nextLine().split(" ");
        int maxLoad=Integer.parseInt(sc.nextLine());
        int[]wights=new int[strs.length];
        for(int i = 0; i < wights.length;i++) {
            wights[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(findMinBoat(wights,maxLoad));
    }
    public static int findMinBoat(int[] wights,int maxLoad){
        //数组从小到大进行排序
        Arrays.sort(wights);
        int count=0;
        int i=0;
        int j=wights.length-1;
        while(i<j){
            if(wights[i]+wights[j]<=maxLoad){
                i++;
                j--;
            }else {
                j--;

            }
            count++;
        }
        return count+((j==i)?1:0);
    }
}
