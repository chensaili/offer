package suanfa.demo.LeetCode.demo20190910;

import java.util.ArrayList;
import java.util.List;

//442
// 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
//找到所有出现两次的元素。
//要求：不用到任何额外空间并在O(n)时间复杂度内解决这个问题

public class FindDuplicates {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> res=findDuplicates(nums);
        for(Integer in:res){
            System.out.print(in+" ");
        }
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0) {
                res.add(Math.abs(nums[i]));
            }else {
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }
        return res;
    }
}
