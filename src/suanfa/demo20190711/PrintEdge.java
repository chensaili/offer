package suanfa.demo20190711;

public class PrintEdge {
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
        print(root);
    }
    public static void print(TreeNode root){
        if(root==null){
            return;
        }
        //获取二叉树的高度
        int height=getMaxHeight(root,0);
        //将二叉树每一层的最左和最右端的节点放入map集合中
        TreeNode[][]edgeMap=new TreeNode[height][2];
        setEdgeMap(root,0,edgeMap);
        //打印最左端的节点
        for(int i=0;i<height;i++){
            System.out.print(edgeMap[i][0].value+" ");
        }
        //打印不是最左端和最右端节点的叶子节点
        printLeafNotInMap(root,0,edgeMap);
        //打印右边界，但不是左边界的节点
        for(int i=height-1;i>=0;i--){
            if(edgeMap[i][0]!=edgeMap[i][1]){
                System.out.print(edgeMap[i][1].value+" ");
            }
        }
    }
    //获取二叉树的高度(关键)
    public static int getMaxHeight(TreeNode node,int height){
        if(node==null){
            return height;
        }
       return Math.max(getMaxHeight(node.left,height+1),getMaxHeight(node.right,height+1));
    }
    //将二叉树每一层的最左和最右的节点放入map集合中(关键)，node和level是对应的关系
    public static void setEdgeMap(TreeNode node,int level,TreeNode[][]edgeMap){
        if(node==null){
            return;
        }
        edgeMap[level][0]=edgeMap[level][0]==null?node:edgeMap[level][0];
        edgeMap[level][1]=node;
        setEdgeMap(node.left,level+1,edgeMap);
        setEdgeMap(node.right,level+1,edgeMap);
    }

    public static void printLeafNotInMap(TreeNode node,int level,TreeNode[][]edgeMap){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null&&
                node!=edgeMap[level][0]&&node!=edgeMap[level][1]){
            System.out.println(node.value+" ");
        }
        printLeafNotInMap(node.left,level+1,edgeMap);
        printLeafNotInMap(node.right,level+1,edgeMap);
    }
}
