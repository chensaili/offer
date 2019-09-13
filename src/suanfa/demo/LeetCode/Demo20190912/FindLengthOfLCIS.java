package suanfa.demo.LeetCode.Demo20190912;
//674。给定一个未经排序的整数数组
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[]nums=new int[]{1,3,2,4,5};
        System.out.println(findLengthOfLCIS1(nums));
        System.out.println(findLengthOfLCIS2(nums));
    }
    //找到最长且连续的递增序列
    public static int findLengthOfLCIS1(int[] nums) {
        int[]arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=1;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                arr[i+1]+=arr[i];
            }
        }
        int max=0;
        for(int in:arr){
            if(in>max){
                max=in;
            }
        }
        return max;
    }

    //找到最长的递增序列
    public static int findLengthOfLCIS2(int[] nums) {
        int[]arr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=1;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                arr[i+1]+=arr[i];
            }else {
                arr[i+1]=arr[i];
            }
        }
        int max=0;
        for(int in:arr){
            if(in>max){
                max=in;
            }
        }
        return max;
    }
}
