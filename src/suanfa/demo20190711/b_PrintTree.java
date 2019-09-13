package suanfa.demo20190711;

/**
 * 较为直观的打印二叉树
 */
public class b_PrintTree {
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
        printTree(root);
    }
    public static void printTree(TreeNode root){
        System.out.println("binary tree:");
        printInOrder(root,0,"H",17);
        System.out.println();
    }
    //root和height是对应的
    public static void printInOrder(TreeNode root ,int height, String to ,int len){
        if(root==null){
            return;
        }
        //打印右子树
        printInOrder(root.right,height+1,"V",len);

        String val=to+root.value+to;
        int lenM=val.length();//节点value的长度
        int lenL=(len-lenM)/2;//左边的空格数
        int lenR=len-lenM-lenL;//右边的空格数
        val=getSpace(lenL)+val+getSpace(lenR);
        System.out.println(getSpace(height*len)+val);//getSpace(height*len)是为了使每一行错开

        //打印左子树
        printInOrder(root.left,height+1,"A",len);
    }

    //将打印的每一个节点的长度设计为17
    public static String getSpace(int num){
        String space=" ";
        StringBuffer sb=new StringBuffer("");
        for(int i=0;i<num;i++){
            sb.append(space);
        }
        return sb.toString();
    }
}
