package demo0605;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class a_IsBalanced {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(TreeNode root){
        //如果为空树，则为平衡二叉树
        if(root==null){
            return true;
        } else if(Math.abs(treeDepth(root.left)-treeDepth(root.right))>1){
            return false;
        }else {
            return isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    public static int treeDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=treeDepth(root.left);
        int right=treeDepth(root.right);
        return Math.max(left,right)+1;
    }
}
