package suanfa.demo20190724;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？
 * 比如: n = 10, n! = 3628800,所以答案为2
 */
public class c_ZeroCount {
    public static void main(String[] args) {
        System.out.println(zeroCount(25));
    }
    public static int zeroCount(int n){
        //当n=25的时候，25！=1*2*3*4*……*24*25，能被5整除的有5,10,15,20,25
        //5贡献1个，10贡献1个，15贡献1个，20贡献1个，25贡献2个
        //共计6个
        //所以可以看出这里应该要用for循环
        int count=0;
        for(int i=0;i<n;i++){
            n=n/5;
            count+=n;
        }
        return count;
    }
}
