package suanfa.demo20190710;

/**
 * 将搜索二叉树转换成有序的双向链表
 */
public class b_Convert {
    public static TreeNode convert(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.right==null&&root.left==null){
            return root;
        }
        //1.将左子树转换为双向链表，返回头节点
        TreeNode left=convert(root.left);
        //2.寻找该链表的最后一个节点
        TreeNode p=left;
        while(p!=null&&p.right!=null){
            p=p.right;
        }
        //3.如果左子树不为空，那么将根节点与左子树转换成的链表的最后一个节点相连
        if(left!=null){
            p.right=root;
            root.left=p;
        }
        //4.将右子树转换成双向链表，返回右子树的头节点
        TreeNode right=convert(root.right);
        //5.如果右子树不为空，那么将右子树的第一个节点和根节点连接
        if(right!=null){
            right.left=root;
            root.right=right;
        }
        //返回的是链表的头节点
        return left!=null?left:root;
    }
}
