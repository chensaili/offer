package suanfa.demo20190711;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 */
public class SerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        root.left=node1;
        root.right=node2;
        System.out.println(serialize(root));
    }
    //使用先序遍历序列化二叉树
    public static String serialize(TreeNode root){
        if(root==null){
           return "#!";
        }
        String res=root.value+"!";
        res+=serialize(root.left);
        res+=serialize(root.right);
        return res;
    }
    //反序列化
    public static TreeNode deserialize(String str){
        String[]strs=str.split("!");
        Queue<String>queue=new LinkedList<>();
        for(int i=0;i!=strs.length;i++){
            queue.offer(strs[i]);//当队列已满，offer方法会返回false，add方法会抛出异常，put方法会阻塞
        }
        return deserializeByPre(queue);
    }
    public static TreeNode deserializeByPre(Queue<String>queue){
        String value=queue.poll();
        if(value.equals("#")){
            return null;
        }
        TreeNode head=new TreeNode(Integer.valueOf(value));
        head.left=deserializeByPre(queue);
        head.right=deserializeByPre(queue);
        return head;
    }
}
