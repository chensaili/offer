package suanfa.demo.LeetCode.demo20190910;
//429
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        LinkedList<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();//记录每一层的大小
            List<Integer>arr=new ArrayList<>();//用来记录每一层
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                arr.add(node.val);
                List<Node> children = node.children;
                if( children!= null && children.size() > 0){
                    for( Node n : children){
                        queue.add(n);
                    }
                }
            }
            res.add(arr);
        }
        return res;
    }
}