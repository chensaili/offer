package suanfa.demo20190718;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 之字形打印二叉树
 */
public class c_PrintTreeZigZag {
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
        Deque<TreeNode> dq=new LinkedList<>();//Deque双端队列
        int level=1;
        boolean lr=true;
        TreeNode curLast=root;
        TreeNode nextLast=null;
        dq.offerFirst(root);//从左到右：头部出，尾部进（先左孩子后右孩子）；从右到左：头部进（先右孩子后左孩子），尾部出，
        printLevelAndOriention(level++,lr);
        while(!dq.isEmpty()){
            //从左到右
            if(lr){
                root=dq.pollFirst();//头部出
                if(root.left!=null){
                    nextLast=nextLast==null?root.left:nextLast;
                    dq.offerLast(root.left);
                }
                if(root.right!=null){
                    nextLast=nextLast==null?root.left:nextLast;
                    dq.offerLast(root.right);
                }
            }else {
                //从右到左
                root=dq.pollLast();
                if(root.right!=null){
                    nextLast=nextLast==null?root.right:nextLast;
                    dq.offerFirst(root.right);
                }
                if(root.left!=null){
                    nextLast=nextLast==null?root.right:nextLast;
                    dq.offerFirst(root.left);
                }
            }
            System.out.print(root.value+" ");
            if(root==curLast&&!dq.isEmpty()){
                lr=!lr;
                curLast=nextLast;
                nextLast=null;
                System.out.println();
                printLevelAndOriention(level++,lr);
            }
        }
        System.out.println();
    }
    //根据布尔值决定从左到右还是从右到左打印
    public static void printLevelAndOriention(int level,boolean lr){
        System.out.print("level "+level+" from ");
        System.out.print( lr ?"left to right: ":"right to left: ");
    }
}
