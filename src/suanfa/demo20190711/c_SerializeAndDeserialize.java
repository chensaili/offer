package suanfa.demo20190711;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 */
public class c_SerializeAndDeserialize {
    public static void main(String[] args) {
        /*TreeNode root=new TreeNode(0);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        root.left=node1;
        root.right=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;*/
        TreeNode root=new TreeNode(0);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        root.left=node1;
        root.right=node2;
        System.out.println(serilize(root));
        TreeNode newRoot=deserilize(serilize(root));
       b_PrintTree.printTree(newRoot);
    }
    //使用先序遍历，二叉树序列化
    public static String serilize(TreeNode root){
        if(root==null){
            return "#!";
        }
        String res=root.value+"!";//想一下为什么要加“！”
        res+=serilize(root.left);
        res+=serilize(root.right);
        return res;
    }
    //反序列化（比较难理解）
    public static TreeNode deserilize(String preStr){
        String[]strs=preStr.split("!");
        Queue<String>queue=new LinkedList<>();
        for(int i=0;i!=strs.length;i++){
            queue.offer(strs[i]);
        }
        return deserilzeByPre(queue);
    }
    public static TreeNode deserilzeByPre(Queue<String>queue){
        String value=queue.poll();
        if(value.equals("#")){
            return null;
        }
        TreeNode head=new TreeNode(Integer.valueOf(value));
        head.left=deserilzeByPre(queue);
        head.right=deserilzeByPre(queue);
        return head;
    }
}
