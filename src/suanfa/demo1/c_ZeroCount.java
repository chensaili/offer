package suanfa.demo1;
/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？
 * 比如: n = 10, n! = 3628800,所以答案为2
 * 解题思路：求末尾几个0，就看这个数有几个10因子，10=5*2，
 * 但是最后得到的结果2的个数一定多于5的个数，
 * 所以只需要求5的个数就可以了。
 * 但是就像25这种数字，它可以被5除两次，所以我们要在循环中除以5，
 * 最后把除5的个数累加就可以了。
 */
public class c_ZeroCount {
    public static void main(String[] args) {
        System.out.println(count(25));
    }
    public static int count(int n){
        int count=0;
        for(int i=0;i<n;i++){
            n=n/5;
            count=count+n;
        }
        return count;
    }
}
