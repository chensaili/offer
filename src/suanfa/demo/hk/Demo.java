package suanfa.demo.hk;

/*
 * 一个数如果恰好等于它的因子之和，这个数就称为“完数“
 * 例如6的因子为1，2，3，而6=1+2+3，因此6是”完数“
 * 编写一个小应用程序求1000之内所有的完数
 * 因子：一个数，如果存在可以被它整除的数且这些数不包括它本身，则这些数都是该数的因子
 */
public class Demo {
    public static void main(String[] args) {
        for(int i=1;i<=1000;i++){
            int sum=0;//因子的和
            for(int j=1;j<i;j++){
                if(i%j==0){
                    sum+=j;
                }
            }
            if(sum==i){
                System.out.print(i+" ");
            }
        }
    }
}
