package demo0616;
/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class a_IsSymmetrical {
    public static boolean isSymmetrical(TreeNode root){
        if(root==null){
            return true;
        }
        return proccess(root.left,root.right);
    }
    public static boolean proccess(TreeNode leftNode,TreeNode rightNode){
        if(leftNode==null&&rightNode==null){
            return true;
        }
        if(leftNode!=null&&rightNode!=null){
            return leftNode.val==rightNode.val
                    &&proccess(leftNode.left,rightNode.right)
                    &&proccess(leftNode.right,rightNode.left);
        }
        return false;
    }
}
