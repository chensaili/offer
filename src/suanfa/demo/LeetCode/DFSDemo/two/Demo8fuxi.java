package suanfa.demo.LeetCode.DFSDemo.two;

import java.util.Scanner;

//迷宫
public class Demo8fuxi {

    private static int[][]direction=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private static int fx;
    private static int fy;
    private static int n=5;//迷宫的行数
    private static int m=5;//迷宫的列数
    private static int[][]square=new int[n][m];//代表迷宫
    private static int[][]book=new int[n][m];//代表迷宫中的位置是否被走过

    private static int min= Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入迷宫5*5：");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                square[i][j]=sc.nextInt();
            }
        }
        System.out.println("请输入人质的位置：");
        fx = sc.nextInt();
        fy = sc.nextInt();
        dfs(0,0,0);
        //从（0,0）开始走，到人质的位置至少需要走多少路
        System.out.println(min);
    }
    public static void dfs(int x,int y,int step){
        //表示已经走到人质的位置
        if(x==fx&&y==fy){
            if(step<min){
                min=step;
            }
            return;
        }
        //接下来是还没有到人质位置的情况,那么就需要往四个方向走
        for(int i=0;i<4;i++){
            int tx=direction[i][0];
            int ty=direction[i][1];
            if(tx+x<0||tx+x>=m){
                continue;
            }
            if(ty+y<0||ty+y>=n){
                continue;
            }
            if(square[x+tx][y+ty]==0&&book[x+tx][y+ty]==0) {
                book[x + tx][y + ty] = 1;
                dfs(x+tx,y+ty,step+1);
                book[x + tx][y + ty] = 0;
            }
        }
        return;
    }
}
