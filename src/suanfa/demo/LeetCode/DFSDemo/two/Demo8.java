package suanfa.demo.LeetCode.DFSDemo.two;

import java.util.Scanner;

/**
 * 5*5迷宫初始化如下
0 0 1 0 1
0 0 0 0 1
0 0 1 0 0
0 1 0 0 1
0 0 0 0 1
 * 初始位置在（0,0）处，欲到达（3,2）处最少需要走多少步
 */
//迷宫（深度优先搜索）
public class Demo8 {
    public static int fx,fy;//人质所在的位置
    public static int n=5;
    public static int [][]direction={{0,1},{1,0},{0,-1},{-1,0}};
    public static int [][] squera = new int [n][n];//迷宫
    public static int [][] book = new int [n][n];//表示迷宫的位置是否已经走过
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        System.out.println("请输入迷宫5*5：");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                squera[i][j] = scan.nextInt();
            }
        }
        System.out.println("请输入人质所在位置：");
        fx = scan.nextInt();
        fy = scan.nextInt();
        book[0][0]=1;//把走过的位置标记为1
        dfs(0,0,0);
        System.out.println(min);
    }
    public static void dfs(int x,int y,int step){
        //如果到达地点，结束
        if(x==fx&&y==fy){
            if(step<min){
                min=step;
            }
            return;
        }
        for(int i=0;i<4;i++){
            int tx=direction[i][0];
            int ty=direction[i][1];
            //越界的情况
            if(x+tx<0||x+tx>=n){
                continue;
            }
            //越界的情况
            if(y+ty<0||y+ty>=n){
                continue;
            }
            //表示这条路可以走，并且没有走过
            if(squera[x+tx][y+ty]==0&&book[x+tx][y+ty]==0){
                book[x+tx][y+ty] = 1;//标记为走过
                dfs(x+tx,y+ty,step+1);//往下一层递归
                book[x+tx][y+ty] = 0;//取消标记，返回上一层
            }
        }
        return;
    }
}
