package demo0324;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class c_FindPath {
    public ArrayList<ArrayList<Integer>>res=new ArrayList<>();
    public ArrayList<Integer>path=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target){
        if(root==null){
            return res;
        }
        path.add(root.val);
        //到达叶节点时，整条路径的和为目标和，则将此条路径加入res
        if(root.left==null&&root.right==null&&root.val==target){
            res.add(new ArrayList<Integer>(path));
        }
        if(root.left!=null&&root.val<target){
            findPath(root.left,target-root.val);
        }
        if(root.right!=null&&root.val<target){
            findPath(root.right,target-root.val);
        }
        //移除最后一个元素，深度遍历完一条路径后要回退
        path.remove(path.size()-1);
        return res;
    }
}
