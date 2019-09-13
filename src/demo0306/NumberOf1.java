package demo0306;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(numberOf1(-1));
    }
    public static int numberOf1(int n){
        if(n==0){
            return 0;
        }
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
     return count;
    }
}
