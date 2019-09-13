package suanfa.demo20190719;

import java.util.HashMap;

/**
 * 先序和中序数组重构二叉树
 * 中序和后序数组重构二叉树也是一样的思路
 */
public class b_PreInToTree {
    public static TreeNode preInToTree(int[]pre,int[]in){
        if(pre==null||in==null){
            return null;
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return rebuild(pre,0,pre.length-1,in,0,in.length-1,map);
    }
    public static TreeNode rebuild(int[]pre, int pi, int pj, int[]in, int ii, int ij, HashMap<Integer,Integer>map){
        if(pi>pj){
            return null;
        }
        TreeNode root=new TreeNode(pre[pi]);//整颗树的根节点是先序遍历数组的第一个元素
        int index=map.get(pre[pi]);//找到先序遍历数组第一个元素在中序遍历数组的索引
        //注意下面传入的参数值
        root.left=rebuild(pre,pi+1,pi+(index-ii),in,ii,index-1,map);
        root.right=rebuild(pre,pi+(index-ii)+1,pj,in,index+1,ij,map);
        return root;
    }
}
