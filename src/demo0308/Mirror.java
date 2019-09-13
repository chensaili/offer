package demo0308;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 */
public class Mirror {
    public static void mirror(TreeNode root){
        //为空树的情况
        if(root==null){
            return;
        }
        //只有一个节点的情况
        if(root.right==null&&root.left==null){
            return;
        }
        //互换
        TreeNode temp;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.right!=null){
            mirror(root.right);
        }
        if(root.left!=null){
            mirror(root.left);
        }
    }
}
