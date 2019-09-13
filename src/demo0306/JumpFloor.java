package demo0306;

public class JumpFloor {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     */
    /**
     * 假设现在6个台阶，我们可以从第5跳一步到6，这样的话有多少种方案跳到5就有多少种方案跳到6，
     * 另外我们也可以从4跳两步跳到6，跳到4有多少种方案的话，就有多少种方案跳到6
     * 故f(6)=f(5)+f(4)
     * 其实就是一个斐波那锲数列
     */
    public static int jumpFloor1(int n){
        if(n<=0){
            return 0;
        }
        if(n==1||n==2){
            return n;
        }else {
         return jumpFloor1(n-1)+jumpFloor1(n-2);
        }
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     * f(n) = 2*f(n-1)
     */
    public static int jumpFloor2(int n){
        if(n==1) {
            return 1;
        }
        return 2*jumpFloor2(n-1);
    }



    public static void main(String[] args) {
        System.out.println(jumpFloor1(4));
    }
}
