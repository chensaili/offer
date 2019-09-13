package suanfa.demo.LeetCode.DFSDemo.two;
//最大岛屿面积（深度优先搜索）
public class Demo7 {
    private int m;
    private int n;
    private int[][] direction={{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int maxArea = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                maxArea = Math.max(dfs(grid, i, j), maxArea);
            }
        }
        return maxArea;
    }

    private int dfs(int [][] grid, int row, int col){
        if(row<0 || row>=m ||col<0 || col>=n){
            return 0;
        }
        if(grid[row][col]==0){
            return 0;
        }

        grid[row][col]=0;//将已经走过的陆地标记为水
        int area=1;
        for(int[]d:direction){
            area+=dfs(grid,row+d[0],col+d[1]);
        }
        return area;
    }
}
