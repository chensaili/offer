package demo0617;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class b_MovingCount {
    public static int movingCount(int threshold, int rows, int cols){
        boolean[][]flag=new boolean[rows][cols];
        return countStep(threshold,rows,cols,0,0,flag);
    }
    public static int countStep(int threshold, int rows, int cols,int curx,int cury,boolean[][] flag) {
        //递归结束条件
        if(curx<0||curx>=rows||cury<0||cury>=cols||getSum(curx)+getSum(cury)>threshold||flag[curx][cury]) {
            return 0;
        }
        flag[curx][cury]=true;
        return  countStep(threshold,rows,cols,curx+1,cury,flag)+
                countStep(threshold,rows,cols,curx-1,cury,flag)+
                countStep(threshold,rows,cols,curx,cury+1,flag)+
                countStep(threshold,rows,cols,curx,cury-1,flag)+1;
    }
    //求各个位上数字之和
    public static int getSum(int cur) {
        if(cur<10) {
            return cur;
        }
        int sum=0;
        while(cur!=0) {
            sum=cur%10+sum;
            cur=cur/10;
        }
        return sum;
    }
}
