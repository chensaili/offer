package suanfa.demo.LeetCode.demo20190910.dynamic;
//343
//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
// 返回你可以获得的最大乘积。
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(6));
    }
    public static int integerBreak(int n) {
        if(n<=3){
            return n-1;
        }
        int[] dp=new int[n+1];
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=max3(dp[i],j*dp[i-j],j*(i-j));
            }
        }
        return dp[n];
    }
    private static int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }
    private static int max2(int num1, int num2) {
        return Math.max(num1, num2);
    }
}
