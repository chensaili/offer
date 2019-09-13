package suanfa.demo.LeetCode.demo20190910;

import java.util.Stack;

//938。这个题字面含义很难理解，本意就是求出二叉搜索树中满足 X >= L 且 X <= R 所有节点的值的和
public class RangeBST {
    /*//和没有注释掉的部分其实是一样的，就是没有被注释的那部分更让我理解
    public static int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if(root.val<L){
            return rangeSumBST(root.right,L,R);
        }
        if(root.val>R){
            return rangeSumBST(root.left,L,R);
        }
        return root.val+rangeSumBST(root.right,L,R)+rangeSumBST(root.left,L,R);
    }*/
    //使用递归
    int ans;
    public int rangeSumBST2(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }
    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }


    //不使用递归，使用栈
    public int rangeSumBST3(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (L <= node.val && node.val <= R) {
                    ans += node.val;
                }
                //下面两个if前后顺序都可以
                if (L < node.val) {
                    stack.push(node.left);
                }
                if (node.val < R) {
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }
}
