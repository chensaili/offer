package demo0520fuxi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 前序、中序、后序、层序打印二叉树
 */
public class j_PrintTree {
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
        print(n1);
    }
    //从上往下打印出二叉树的每个节点，同层节点从左至右打印，并需要分层打印。
    public static void print(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        //用两个变量表示当前行的最后一个节点和下一行的最后一个节点
        TreeNode curLast=root;
        TreeNode nextLast=null;

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
            //当前的根节点为该行的最后一个节点时，需要有一个换行的符号，实现分层打印，
            if(root==curLast){
                curLast=nextLast;
                System.out.println();
            }
        }
    }
    //前序
    public static void prePrint(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val+" ");
        prePrint(root.left);
        prePrint(root.right);
    }
    //中序
    public static void inPrint(TreeNode root){
        if(root==null){
            return;
        }
        prePrint(root.left);
        System.out.println(root.val+" ");
        prePrint(root.right);
    }
    //后序
    public static void posPrint(TreeNode root){
        if(root==null){
            return;
        }
        prePrint(root.left);
        prePrint(root.right);
        System.out.println(root.val+" ");
    }
}
