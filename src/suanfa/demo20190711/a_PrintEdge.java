package suanfa.demo20190711;

/**
 * 打印二叉树的边界节点（头节点、每一行最左和最右的节点，叶子节点是边界节点）
 * 我比较陌生的地方（都是递归）：
 * 1.如何求二叉树的高度
 * 2.如何将二叉树每一层的最左和最右的节点放入map集合中
 */
public class a_PrintEdge {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        root.left=node1;
        root.right=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
       // System.out.println(getHeight(root,0));
        /*TreeNode root=new TreeNode(0);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        root.left=node1;
        root.right=node2;*/
       print(root);
    }
    public static void print(TreeNode root){
        if(root==null){
            return;
        }
        //获取二叉树的高度
        int heghit=getHeight(root,0);
        TreeNode[][]edgeMap=new TreeNode[heghit][2];//height行，2列，第一行放的是第一行的最左和最右的节点
        //将二叉树每一层的最左和最右的节点放入map集合中
        setEdgeMap(root,0,edgeMap);
        //1.打印左边界
        for(int i=0;i!=edgeMap.length;i++){
            System.out.print(edgeMap[i][0].value+" ");
        }
        //2.打印既不是左边界，也不是右边界的叶子节点
        printLeafNotInMap(root,0,edgeMap);
        //3.打印右边界，但不是左边界的节点
        for(int i=edgeMap.length-1;i>=0;i--){
            if(edgeMap[i][0]!=edgeMap[i][1]){
                System.out.print(edgeMap[i][1].value+" ");
            }
        }
    }
    //获取二叉树的高度(一定要记住了)
    public static int getHeight(TreeNode node,int h){
        if(node==null){
            return h;
        }
        return Math.max(getHeight(node.left,h+1),getHeight(node.right,h+1));
    }
    //将二叉树每一层最左和最右的节点放入map集合中（这里的node和level是对应的关系，root位于二叉树的第0行，那么level就是0）
    public static void setEdgeMap(TreeNode node,int level,TreeNode[][]edgeMap){
        if(node==null){
            return;
        }
        //这个地方想了很久很久
        edgeMap[level][0]=edgeMap[level][0]==null?node:edgeMap[level][0];//二维数组的第一列一旦设定了就不会变了
        edgeMap[level][1]=node;//二维数组的第二列，存储的是二叉树每一行最右边的节点，这一列的值会随着递归的进行改变
        setEdgeMap(node.left,level+1,edgeMap);
        setEdgeMap(node.right,level+1,edgeMap);
    }
    //打印既不是左边界，也不是右边界的叶子节点
    public static void printLeafNotInMap(TreeNode node,int l,TreeNode[][]edgeMap){
        if(node==null){
            return;
        }
        //先序遍历
        if(node.left==null&&node.right==null&&node!=edgeMap[l][0]&&node!=edgeMap[l][1]){
            //打印不是最左和最右节点的叶子节点
            System.out.print(node.value+" ");
        }
        printLeafNotInMap(node.left,l+1,edgeMap);
        printLeafNotInMap(node.right,l+1,edgeMap);
    }
}
