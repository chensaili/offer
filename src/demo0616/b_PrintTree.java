package demo0616;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层打印二叉树，每一层打印一行
 */
public class b_PrintTree {
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
        TreeNode curLast=root;//当前行的最后一个节点
        TreeNode nextLast=null;//下一行的最后一个节点
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root=queue.poll();
            System.out.print(root.val+" ");
            if(root.left!=null){
                queue.add(root.left);
                nextLast=root.left;
            }
            if(root.right!=null){
                queue.add(root.right);
                nextLast=root.right;
            }
            if(root==curLast){
                curLast=nextLast;
                System.out.println();
            }
        }
    }
}
