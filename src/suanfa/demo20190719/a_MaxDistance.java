package suanfa.demo20190719;

/**
 * 二叉树两个节点间的最大距离
 * 后序遍历
 * 为什么要使用数组，而不是使用常量？
 */
public class a_MaxDistance {
    public static int getMaxDistance(TreeNode root){
        int[]record=new int[1];
        return posOrder(root,record);
    }
    public static int posOrder(TreeNode node,int[]record){
        if(node==null){
            record[0]=0;
            return 0;
        }
        /**
         * 后序遍历
         */
        //左子树
        int lMax=posOrder(node.left,record);//node的左子树的最大距离
        int maxFromLeft=record[0];//node的左子树上离node.left的最大距离，就是左子树的高度
        //右子树
        int rMax=posOrder(node.right,record);//node的右子树的最大距离
        int maxFromRight=record[0];//node的右子树上离node.right的最大距离，就是右子树的高度
        //当前节点
        int curNodeMax=maxFromLeft+maxFromRight+1;//当前节点的最大距离
        record[0]=Math.max(maxFromLeft,maxFromRight)+1;//当前节点的高度

        return Math.max(Math.max(lMax,rMax),curNodeMax);
    }
}
