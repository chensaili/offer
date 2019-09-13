package suanfa.demo20190718;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层打印二叉树
 * 层级遍历
 */
public class b_PrintTreeByLevel {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n2.right=n4;
        print(root);
    }
    public static void print(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode curLast=root;//记录当前行的最后一个节点
        TreeNode nextLast=null;//记录下一行的最后一个节点
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int level=1;
        System.out.print("level "+(level++)+":");
        while(!queue.isEmpty()){
            root=queue.poll();
            System.out.print(root.value+" ");
            if(root.left!=null){
                queue.add(root.left);
                nextLast=root.left;
            }
            if(root.right!=null){
                queue.add(root.right);
                nextLast=root.right;
            }
            //这里需要注意的是!queue.isEmpty()这个条件，如果没有这个条件，那么还会打印一行level 4：
            if(curLast==root&&!queue.isEmpty()){
                curLast=nextLast;
                System.out.println();//换行
                System.out.print("level "+(level++)+":");
            }
        }
    }
}
