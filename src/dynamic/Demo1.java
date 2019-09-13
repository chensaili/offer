package dynamic;

/**
 * 使用动态规划的自底向上（先计算子问题，再由子问题计算父问题）实现斐波那锲数列
 */
public class Demo1 {
    public static void main(String[]args){
        System.out.println(fib(4));
    }
    public static int fib(int n){
        if(n<=0){
            return 0;
        }
        int[]memo=new int[n+1];
        memo[0]=0;
        memo[1]=1;
        for(int i=2;i<=n;i++){
            memo[i]=memo[i-1]+memo[i-2];
        }
        return memo[n];
    }
}
