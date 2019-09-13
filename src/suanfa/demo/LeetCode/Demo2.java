package suanfa.demo.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 根据每日气温列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[]res=dailyTemperatures(nums);
        for(Integer in:res){
            System.out.print(in+" ");
        }
    }
    /*
    public static int[] dailyTemperatures(int[] nums) {
        int[]res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    res[i] = j - i;
                    break;
                }

            }
        }
        return res;
    }*/
    public static int[] dailyTemperatures(int[] nums) {
        int len=nums.length;
        int[]res=new int[len];
        for(int i=len-2;i>=0;i--){
           for(int j=i+1;j<len;j+=res[j]){
               if(nums[j]>nums[i]){
                   res[i]=j-i;
                   break;
               }else  if (res[j] == 0){
                   res[i]=0;
                   break;
               }
           }
        }
        return res;
    }
}
