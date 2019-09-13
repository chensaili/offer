package demo0604;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class d_TreeDepth {
    //递归版本
    public static int findDepth1(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=findDepth1(root.left);
        int right=findDepth1(root.right);
        return Math.max(left,right)+1;
    }
    //非递归，就是层级遍历
    public static int findDepth2(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);

        int count=0;
        int totalCount=1;
        int deep=0;
        while(!queue.isEmpty()){
            root=queue.poll();
            count++;
            if(root.left!=null){
                queue.add(root.left);
            }
            if(root.right!=null){
                queue.add(root.right);
            }
            if(count==totalCount){
                totalCount=queue.size();
                count=0;
                deep++;
            }
        }
        return deep;
    }
}
