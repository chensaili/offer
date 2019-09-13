package suanfa.demo20190711;

public class PrintTree {
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
        System.out.println("binary tree: ");
        printInOrder(root,0,"H",17);
        System.out.println();
    }
    //len为11
    public static void printInOrder(TreeNode root,int height,String to,int len){
        if(root==null){
            return;
        }
        //打印右子树
        printInOrder(root.right,height+1,"V",len);
        String val=to+root.value+to;
        int lenM=val.length();
        int lenL=(len-lenM)/2;
        int lenR=len-lenM-lenL;
        val=getSpace(lenL)+val+getSpace(lenR);//此时的val是加了空格之后长度为17的字符串
        System.out.println(getSpace(height*len)+val);
        //打印左子树
        printInOrder(root.left,height+1,"A",len);
    }
    public static String getSpace(int num){
        String space=" ";
        StringBuffer sb=new StringBuffer("");
        for(int i=0;i<num;i++){
            sb.append(space);
        }
        return sb.toString();
    }
}
