package suanfa.demo20190718;

import suanfa.demo20190709.ListNode;

/**
 * 找到二叉树中（已知二叉树中所有节点的值都不一样）的最大搜索二叉树
 * 还未理解
 */
public class a_BiggestSubBST {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(4);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(1);
        TreeNode node5=new TreeNode(2);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        findBiggestSubBST(node1);
    }
    public static TreeNode findBiggestSubBST(TreeNode root){
        int[]record=new int[3];
        return posOrder(root,record);
    }
    public static TreeNode posOrder(TreeNode root,int[] record){
        if(root==null){
            record[0]=0;
            record[1]=Integer.MAX_VALUE;
            record[2]=Integer.MIN_VALUE;
            return null;
        }
        int value=root.value;
        TreeNode left=root.left;
        TreeNode right=root.right;
        TreeNode lBST=posOrder(root.left,record);
        int lSize=record[0];
        int lMin=record[1];
        int lMax=record[2];
        TreeNode rBST=posOrder(root.left,record);
        int rSize=record[0];
        int rMin=record[1];
        int rMax=record[2];
        record[1]=Math.min(lMin,rMin);
        record[2]=Math.max(lMax,rMax);
        if(left==lBST&&right==rBST&&lMax<value&&value<rMin){
            record[0]=lSize+rSize+1;
            return root;
        }
        record[0]=Math.max(lSize,rSize);
        return lSize>rSize?lBST:rBST;
    }
}
