package suanfa.demo.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 *
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 *
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。

 * 例：输入：N = 3, paths = [[1,2],[2,3],[3,1]；输出：[1,2,3]
 */
public class Demo3 {
    public static void main(String[] args) {
        int[]res=gardenNoAdj(5, new int[][]{{1,2},{2,3},{3,1},{3,4},{2,4},{4,5}});
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(int i=0;i<N;i++){
            graph.put(i,new HashSet<>());
        }
        //获取与当前节点相连的每个节点
        for(int[]path:paths){
            graph.get(path[0]-1).add(path[1]-1);
            graph.get(path[1]-1).add(path[0]-1);
        }
        //结果
        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            for (int adj: graph.get(i)) {
                used[res[adj]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i] = j;
                }
            }
        }
        return res;
    }
}
