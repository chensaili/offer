package demo0520fuxi;
/**
 * 二叉树的镜像
 */
public class g_Mirror {
    public static void getMirror(TreeNode root){
        //为空树的情况
        if(root==null){
            return ;
        }
        //树只有根节点的情况
        if(root.left==null&&root.right==null){
            return ;
        }
        //其他情况
        //先将当前根节点的左右子树互换
        TreeNode temp;
        temp=root.left;
        root.right=root.left;
        root.left=temp;
        //互换完成后，利用递归，使左右子树当成是独立的树进行相同的操作
        if(root.left!=null){
            getMirror(root.left);
        }
        if(root.right!=null){
            getMirror(root.right);
        }
    }
}
