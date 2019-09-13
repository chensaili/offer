package demo0308;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(4);
        TreeNode n4=new TreeNode(1);
        TreeNode n5=new TreeNode(3);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        System.out.println(contain(n1,n2));
    }
    public static boolean contain(TreeNode root1,TreeNode root2){
        //先判断是否是空树，是的话直接返回false
        if(root1==null||root2==null){
            return false;
        }
        //不能忘记contain(root1.left,root2)||contain(root1.right,root2)，因为树中可能会有元素的重复
        return check(root1,root2)||contain(root1.left,root2)||contain(root1.right,root2);
    }
    public static boolean check(TreeNode t1,TreeNode t2) {
        //这个检查t2是否为null不是为了判断t2是否为空树，而是为了判断t2是否已经遍历完
        if(t2==null){
            return true;
        }
        if(t1==null||t1.val!=t2.val){
            return false;
        }
        return check(t1.left,t2.left)&&check(t1.right,t2.right);
    }
}
