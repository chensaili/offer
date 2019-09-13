package demo0308;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(4);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(6);
        TreeNode n5=new TreeNode(5);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        /*preOrder(n1);
        System.out.println();
        inOrder(n1);
        System.out.println();
        posOrder(n1);*/
        printFromTopToBottom(n1);
    }
    //从上往下打印出二叉树的每个节点，同层节点从左至右打印，并需要分层打印。
    public static void printFromTopToBottom(TreeNode root){
        if(root==null){
            return ;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        //下面两个变量是为了分层打印
        TreeNode curLast=root;
        TreeNode nextLast=null;
        queue.add(root);
        while(!queue.isEmpty()){
            root=queue.poll();
            System.out.print(root.val);
            if(root.left!=null){
                queue.add(root.left);
                nextLast=root.left;
            }
            if(root.right!=null){
                queue.add(root.right);
                nextLast=root.right;
            }
            //关键就是下面的判断，是实现分层打印的地方
            if(root==curLast){
                curLast=nextLast;
                System.out.println();
            }
        }
    }
    public static void preOrder(TreeNode head){
        //先序遍历
        if(head==null){
            return;
        }
        System.out.print(head.val+" ");
        preOrder(head.left);
        preOrder(head.right);
    }
    public static void inOrder(TreeNode head){
        //中序遍历
        if(head==null){
            return;
        }
        inOrder(head.left);
        System.out.print(head.val+" ");
        inOrder(head.right);
    }
    public static void posOrder(TreeNode head){
        //后序遍历
        if(head==null){
            return;
        }
        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.val+" ");
    }
}
