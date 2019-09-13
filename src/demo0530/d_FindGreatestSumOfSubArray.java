package demo0530;

/**
 * 计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和(子向量的长度至少是1)
 */
public class d_FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[]array={6,-3,-2,7,-15,1,2,3};
        System.out.println(findGreatestSumOfSubArray(array));
    }
    public static int findGreatestSumOfSubArray(int[]array){
        if(array==null||array.length==0){
            return 0;
        }
        int maxSum=Integer.MIN_VALUE;//整数的最小值
        int curSum=0;//当前的和
        for(int i=0;i<array.length;i++){
            if(curSum<=0){
                curSum=array[i];
            }else {
                curSum=curSum+array[i];
            }
            if(curSum>maxSum){
                maxSum=curSum;
            }
        }
        return maxSum;
    }
}
