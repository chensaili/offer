package suanfa.demo.LeetCode;

/**
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 *
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 *
 * 返回使 S 单调递增的最小翻转次数
 * 输入："010110"
 * 输出：2
 * 解释：我们翻转得到 011111，或者是 000111。
 */
public class Demo4 {
    public static void main(String[] args) {
        String str="11011";
        System.out.println(minFlipsMonoIncr(str));
    }
    public static int minFlipsMonoIncr(String S) {
        int[]nums=new int[S.length()];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.valueOf(String.valueOf(S.charAt(i)));
        }
        int[]sums=new int[nums.length+1];
        sums[0]=0;
        for(int i=0;i<nums.length;i++){
            sums[i+1]=sums[i]+nums[i];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=nums.length;i++){
            //i=1表示左边有1个0,i=2表示左边有两个0
            //sums[i]表示左边部分（即0的部分）有几个1，有几个1就表示需要翻转几次
            //sums[nums.length]-sums[i]表示右边部分有几个1
            // nums.length-i-(sums[nums.length]-sums[i])就表示右边部分有几个0，有几个0就需要翻转几次
            int count=sums[i]+nums.length-i-(sums[nums.length]-sums[i]);
            if(count<min){
                min=count;
            }
        }
        return min;
    }

}
