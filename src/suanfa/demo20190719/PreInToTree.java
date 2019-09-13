package suanfa.demo20190719;

import java.util.HashMap;

public class PreInToTree {
    public static void main(String[] args) {
        int[]pre=new int[]{1, 2, 4, 5, 8, 9, 3, 6, 7};
        int[]in=new int[]{4, 2, 8, 5, 9, 1, 6, 3, 7};
        TreeNode root=preInToTree(pre,in);
        printTree(root);
    }
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
    public static TreeNode rebuild(int[]pre,int pi,int pj,int[]in,int ii,int ij,HashMap<Integer,Integer>map){
        if(pi>pj){
            return null;
        }
        int index=map.get(pre[pi]);
        TreeNode root=new TreeNode(pre[pi]);
        root.left=rebuild(pre,pi+1,pi+index-ii,in,ii,index-1,map);
        root.right=rebuild(pre,pi+index-ii+1,pj,in,index+1,ij,map);
        return root;
    }

    //直观的打印二叉树（右，中，左）
    public static void printTree(TreeNode root){
        System.out.println("binary tree: ");
        print(root,0,"H",17);
        System.out.println();
    }
    public static void print(TreeNode root,int level,String to,int len){
        if(root==null){
            return;
        }
        print(root.right,level+1,"V",17);

        String val=to+root.value+to;
        int lenM=val.length();
        int lenL=(len-lenM)/2;
        int lenR=len-lenM-lenL;
        val=getSpace(lenL)+val+getSpace(lenR);
        System.out.println(getSpace(level*len)+val);

        print(root.left,level+1,"A",17);
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
