package demo0520fuxi;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方
 * 这个题目很简单，但是考察的很仔细
 * 比如需要考虑到指数为负数时，base不能为0，否则就会出现分母为0的情况
 */
public class b_Power {
    public static double power(double base,Integer exponent){
        int n;
        double result=1;
        if(exponent>0){
            n=exponent;
        }else if(exponent<0){
            if(base==0){
                throw new RuntimeException("分母不能为0");
            }
            n=-exponent;
        }else {
            return 1;
        }
        while (n!=0){
            result=result*base;
            n--;
        }
        return exponent>0?result:1/result;
    }
}
