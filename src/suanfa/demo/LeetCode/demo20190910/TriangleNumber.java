package suanfa.demo.LeetCode.demo20190910;

import java.util.Arrays;
import java.util.Comparator;

//611。给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数
public class TriangleNumber {
    public static void main(String[] args) {
        int[]nums={2,2,3,4};
        System.out.println(number(nums));
    }
    public static int number(int[]nums){
        Integer[]counts=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            counts[i]=Integer.valueOf(nums[i]);
        }
        //对数组进行排序（倒序）
        Arrays.sort(counts,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int res=0;
        for(int i=0;i<counts.length-2;i++){
            int left=i+1;
            int right=counts.length-1;
            while(left<right){
                if(counts[left]+counts[right]>counts[i]){
                    res+=right-left;
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
