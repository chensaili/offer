package suanfa.demo20190719;

/**
 * 二叉树两个节点间最大的距离
 * 后序遍历
 */
public class MaxDistance {
    public static void main(String[] args) {

    }
    public static int maxDistance(TreeNode root){
        int[]record=new int[1];
        return getMaxDistance(root,record);
    }
    public static int getMaxDistance(TreeNode node,int[]record){
        if(node==null){
            record[0]=0;
            return 0;
        }
        //获取左子树的最大节点距离（第一种情况）
        int leftMax=getMaxDistance(node.left,record);
        //获取左子树的高度
        int leftHight=record[0];
        //获取右子树的最大节点距离（第二种情况）
        int rightMax=getMaxDistance(node.left,record);
        //获取右子树的高度
        int rightHight=record[0];
        //获取跨过节点node的最大距离（第三种情况）
        int nodeMax=leftHight+rightHight+1;
        record[0]=Math.max(leftHight,rightHight)+1;
        return Math.max(Math.max(leftMax,rightMax),nodeMax);
    }
}
