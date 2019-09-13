package dynamic;

/**
 * https://blog.csdn.net/u013309870/article/details/75193592
 * 钢条切割
 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(bottomUpCutRod(new int[]{0,1,5,8,9},4));
    }
    /**
     * 动态规划，自底向上求解。
     * @param p，钢条的价格数组，
     * @param n，钢条的长度，这里的划分是以 1 为单位
     * @return 最大收益
     */
    public static int bottomUpCutRod(int[] p,int n){
        //一个数组，用r[i] 来保存 钢条长度为 i 的时候的最优值，初始值赋为 0.
        int[] r= new int[n+1];
        for (int i=1;i<=n;i++){
            r[i]=0;
        }
        //循环,外层依次求解 1....n的最优值
        for (int i=1;i<=n;i++){
            int q=Integer.MIN_VALUE;
            //内层，依次在 1 .. j 中求出最大值，
            //例如
            // 当 i =1 的时候，q=max(q,p[1]+r[0]) .求的r[1]的最优值
            // 当 i =2 的时候，q=max(q,p[1]+r[1])，然后再是 q=max(q,p[2]+r[0]) ，求的r[2]的最优值
            //理解：当i=2时，q=max(q,p[1]+r[1])表示切成两段1+1的，q=max(q,p[2]+r[0]) 表示不切，取其中较大的作为最大利润
            //  ... 以此类推
            for (int j=1;j<=i;j++){
                q=Math.max(q,p[j]+r[i-j]);
            }
            //记录 j 的最优值
            r[i]=q;
        }
        //最终返回 n 的最优值
        return r[n];
    }
}
