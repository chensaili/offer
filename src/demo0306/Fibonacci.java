package demo0306;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 0 1 1 2 3 5 8 13 21。。。
 */
public class Fibonacci {
    public int printFibonacci(int n){
        if(n<=0){
            return 0;
        }
        if(n==1||n==2){
            //斐波那契数列第一项和第二项都为1
            return 1;
        }else {
            return printFibonacci(n-1)+printFibonacci(n-2);
        }
    }
}
