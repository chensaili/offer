package demo0307;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(power(1.2,2));
    }
    public static double power(double base, int exponent) {
        //没有充分考虑到所有情况
        /*if(base==0||exponent==0){
            return 1;
        }
        double result=1;
        while(exponent!=0){
            result=result*base;
            exponent--;
        }
        return result;*/
        int n;
        double result=1;
        //考虑指数的正负数
        if(exponent>0){
            n=exponent;
        }else if(exponent<0){
            //指数为负数的情况下，底数不能为0
            if(base==0){
                throw new RuntimeException("分母不能为0");
            }
            n=-exponent;
        }else {
            //指数为0的情况
            return 1;
        }
        while(n!=0){
            result=result*base;
            n--;
        }
        return exponent>0?result:1/result;
    }
}
