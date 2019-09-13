package demo0516fuxi;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 */
public class g_JumpFloor {
    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }
    /**
     * 假设现在6个台阶，我们可以从第5跳一步到6，这样的话有多少种方案跳到5就有多少种方案跳到6，
     * 另外我们也可以从4跳两步跳到6，跳到4有多少种方案的话，就有多少种方案跳到6
     * 故f(6)=f(5)+f(4)
     * 其实就是一个斐波那锲数列
     * 只是n=2的时候结果不再为1，而是2，一种情况是每次跳一步，另一种情况是一次性跳两步
     */
    public static int JumpFloor(int n){
        if(n<=0){
            return 0;
        }
        if(n==1||n==2){
            return n;
        }else {
            return JumpFloor(n-1)+JumpFloor(n-2);
        }
    }
}
