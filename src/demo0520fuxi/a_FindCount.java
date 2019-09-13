package demo0520fuxi;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 * 补充：
 * 正数的反码是其本身，负数的反码是在其原码的基础上, 符号位不变，其余各个位取反.
 * 正数的补码就是其本身，负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1)
 */
public class a_FindCount {
    public static void main(String[] args) {
        System.out.println(fintCount(-5));
    }
    public static int fintCount(int n){
        if(n==0){
            return 0;
        }
        int count=0;
        //把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
        // 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
