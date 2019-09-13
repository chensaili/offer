package suanfa.demo.LeetCode.DFSDemo.two;
//leetcode第200题
public class Demo9 {
    private  int[][] direction={{0,1},{0,-1},{1,0},{-1,0}};
    private  int count=0;
    private  int m;
    private  int n;
    public int countIsland(char[][] grid){
        if(grid==null||grid.length==0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char [][] grid, int row, int col){
        if(row<0 || row>=m ||col<0 || col>=n){
            return ;
        }
        if(grid[row][col]=='0'){
            return ;
        }

        grid[row][col]='0';//将已经走过的陆地标记

        for(int[]d:direction){
            dfs(grid,row+d[0],col+d[1]);
        }
    }
}
