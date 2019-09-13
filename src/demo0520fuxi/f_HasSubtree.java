package demo0520fuxi;
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class f_HasSubtree {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(2);
        //TreeNode n5=new TreeNode(3);
        n1.left=n2;
        n1.right=n3;
        //n2.left=n4;
        //n2.right=n5;
        System.out.println(contains(n1,n2));
    }
    public static boolean contains(TreeNode root1,TreeNode root2){
        //如果有一颗树为空，那么就返回false
        if(root1==null||root2==null){
            return false;
        }
        //check(root1,root2)判断两颗树的根节点是否相同
        // 如果不相同则判断树1左右子树是否包含树2contains(root1.left,root2)||contains(root1.right,root2)
        return check(root1,root2)||contains(root1.left,root2)||contains(root1.right,root2);
    }
    public static boolean check(TreeNode t1,TreeNode t2){
        //这个if语句是为了判断是否已经遍历完t2
        if(t2==null){
            return true;
        }
        if(t1==null||t1.val!=t2.val){
            return false;
        }
        return check(t1.left,t2.left)&&check(t1.right,t2.right);
    }
}
