package demo0223;

import java.util.HashMap;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历、中序遍历、后序遍历三选二的结果，请重建出该二叉树。
 * 假设输入的前序遍历和、中序遍历和后序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    /*
     * 输入前序和中序遍历结果重建二叉树
     */
    public TreeNode preInToTree(int [] pre,int [] in){
        if(pre==null||in==null){
            return null;
        }
        //使用哈希表存储中序遍历后数组的值(key)和位置(value)
        HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
    }
    public TreeNode preIn(int[]pre,int pi,int pj,int[]in,int ni,int nj,HashMap<Integer,Integer>map){
        if(pi>pj){
            return null;
        }
        //建立二叉树的头节点,这个头节点就是前序遍历的第一个元素
        TreeNode head=new TreeNode(pre[pi]);
        //找出前序遍历第一个元素在中序遍历中的index
        int index=map.get(pre[pi]);
        //使用递归重建左右子树
        //左子树
        head.left=preIn(pre,pi+1,pi+index-ni,in,ni,index-1,map);
        //右子树
        head.right=preIn(pre,pi+index-ni+1,pj,in,index+1,nj,map);
        return head;
    }




    /*
     * 输入中序和后序遍历结果重建二叉树
     */
    public TreeNode InPosToTree(int[]in,int[]pos){
        if(in==null||pos==null){
            return null;
        }
        //使用哈希表存储中序遍历的值和位置
        HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return inPos(in,0,in.length-1,pos,0,pos.length-1,map);
    }
    public TreeNode inPos(int[]in,int ni,int nj,int[]pos,int si,int sj,HashMap<Integer,Integer>map){
        if(si>sj){
            return null;
        }
        //建立二叉树的头节点，该头节点为后序遍历数组最右的元素
        TreeNode head=new TreeNode(pos[sj]);
        //找出后序遍历最后一个元素在中序遍历中的index
        int index=map.get(pos[sj]);
        //使用递归重建左右子树
        //左子树
        head.left=inPos(in,ni,index-1,pos,si,si+(index-ni)-1,map);
        //右子树
        head.right=inPos(in,index+1,nj,pos,si+(index-ni),sj-1,map);
        return head;
    }
}
