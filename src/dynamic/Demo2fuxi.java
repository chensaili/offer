package dynamic;
/**
 * 钢条切割复习
 */
public class Demo2fuxi {
    public static void main(String[] args) {
        System.out.println(bottomUpCutRod(new int[]{0,1,5,8,9},4));
    }
    public static int bottomUpCutRod(int[]price,int n){
        int[]res=new int[n+1];
        for (int i=1;i<=n;i++){
            res[i]=0;
        }
        for(int i=1;i<=n;i++){
            int max=Integer.MIN_VALUE;
            for(int j=1;j<=i;j++){
                max=Math.max(max,price[j]+res[i-j]);
            }
            res[i]=max;
        }
        return res[n];
    }
}
