package suanfa.demo.LeetCode.demo20190910;

import java.util.Stack;

//二叉树的深度优先遍历（其实就是先序遍历）
public class DepthTraversal {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        TreeNode node1=new TreeNode(5);
        TreeNode node2=new TreeNode(15);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(7);
        TreeNode node5=new TreeNode(13);
        TreeNode node6=new TreeNode(17);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        depth1(root);
        System.out.println();
        depth2(root);
    }
    public static void depth1(TreeNode root){
        if(root==null){
            System.out.print("empty tree");
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            System.out.print(root.val+" ");
            //需要先将右子树压入栈中
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
    }
    public static void depth2(TreeNode root){
        if (root!=null&&!root.equals(null))
        {
            System.out.print(root.val+"  ");
            depth2(root.left);
            depth2(root.right);
        }
    }
}
