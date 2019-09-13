package demo0606;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class h_Multiply {
    public static void main(String[] args) {

    }
    //时间复杂度为N^2
    public static int[] multiply1(int[]A){
        int[]B=new int[A.length];
        int res=1;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<i;j++){
                res=res*A[j];
            }
            for(int k=i+1;k<A.length;k++){
                res=res*A[k];
            }
            B[i]=res;
            res=1;
        }
        return B;
    }
    //时间复杂度为N
    public static int[] multiply2(int[]A){
        int[]B=new int[A.length];
        if(A.length!=0){
            B[0]=1;
            //计算下三角连乘
            for(int i=1;i<B.length;i++){
                B[i]=B[i-1]*A[i-1];
            }
            int temp=1;
            //计算
            for(int i=B.length-2;i>=0;i--){
                temp=temp*A[i+1];//计算上三角
                B[i]=B[i]*temp;//等式右边的B[i]表示的已经是下三角连乘后的结果
            }
        }
        return B;
    }
}
