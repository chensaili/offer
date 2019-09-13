package demo0526;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 1、将左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
 * 2、定位到左链表的最后一个节点(左子树最右边的节点)
 * 3、如果左子树链表不为空，则将当前root追加到左子树链表后
 * 4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
 * 5、如果右子树链表不为空，将右子树链表追加到当前root后
 * 6、根据左子树链表是否为空返回的整体双向链表的头节点
 */
public class d_Convert {
    public static TreeNode convert(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.right==null&&root.left==null){
            return root;
        }
        //1.将左子树构成双链表，并返回该链表的头节点
        TreeNode left=convert(root.left);
        //2.定位到左子树链表的最后一个节点
        TreeNode p=left;
        while(p!=null&&p.right!=null){
            p=p.right;
        }
        //3、如果左子树链表不为空，将当前root追加到左子树链表后
        if(left!=null){
            p.right=root;
            root.left=p;
        }
        //4、将右子树构造成双链表，并返回该链表的头结点right
        TreeNode right=convert(root.right);
        //5、如果右子树链表不为空，将右子树链表追加到当前root后
        if(right!=null){
            right.left=root;
            root.right=right;
        }
        //6.根据左子树链表是否为空返回整个双向链表的头指针
        return left!=null?left:root;
    }
}
