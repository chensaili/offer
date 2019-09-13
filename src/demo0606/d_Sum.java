package demo0606;

/**
 * 求1+2+3+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class d_Sum {
    public static void main(String[] args) {
        System.out.println(getSum(9));
    }
    public static int getSum(int n){
        int sum=n;
        boolean ans=(n>0)&&((sum+=getSum(n-1))>0);
        return sum;
    }
}
