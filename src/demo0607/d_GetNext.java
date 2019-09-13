package demo0607;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class d_GetNext {
    public static void main(String[] args) {

    }
    public static TreeListNode getNext(TreeListNode pNode){
        if(pNode==null){
            return null;
        }
        TreeListNode nextNode=null;
        if(pNode.right!=null){
            //如果该节点有右子树，那么该节点的后继节点就是右子树上最左的节点
            return getMostLeftNode(pNode.right);
        }else {
            //注意next指针是指向父节点的
            //如果该节点没有右子树并且该节点是父节点的左子树，那么返回父节点
            TreeListNode parent=pNode.next;
            while (parent!=null&&parent.left!=pNode){
                //如果该节点没有右子树，并且该节点是父节点的右子树,那么继续向上遍历其父节点直到不满足条件
                pNode=parent;
                parent=pNode.next;
            }
            return parent;
        }
    }
    //获得最左节点
    public static TreeListNode getMostLeftNode(TreeListNode node){
        if(node==null){
            return node;
        }
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
}
