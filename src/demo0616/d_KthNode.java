package demo0616;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如,（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class d_KthNode {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(7);
        TreeNode n3=new TreeNode(2);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(6);
        TreeNode n6=new TreeNode(8);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;
        System.out.println(findKthNode1(root,3).val);
        System.out.println(findKthNode2(root,3).val);
    }
    //非递归版本
    public static TreeNode findKthNode1(TreeNode proot,int k){
        if(proot!=null){
            Stack<TreeNode>stack=new Stack<>();
            int count=0;
            while(!stack.isEmpty()||proot!=null){
                if(proot!=null){
                    stack.push(proot);
                    proot=proot.left;
                }else {
                    proot=stack.pop();
                    count++;
                    if(count==k){
                        return proot;
                    }
                    proot=proot.right;
                }
            }
        }
        return null;
    }
    //二叉搜索树中序遍历结果就是从小到大排序的
    //递归版本（不是很理解）
    static int i=0;
    public static TreeNode findKthNode2(TreeNode proot,int k){
        if(proot!=null){
            TreeNode node=findKthNode2(proot.left,k);
            //下面的三行代码不是很理解
            if(node!=null){
                return node;
            }
            i++;
            if(i==k){
                return proot;
            }
            node=findKthNode2(proot.right,k);
            if(node!=null){
                return node;
            }
        }
        return null;
    }
}
