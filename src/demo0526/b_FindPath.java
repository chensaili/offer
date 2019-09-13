package demo0526;


import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class b_FindPath {
    static ArrayList<Integer>path=new ArrayList<>();
    static ArrayList<ArrayList<Integer>>result=new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root,int num){
        if(root==null){
            return result;
        }
        path.add(root.val);
        if(root.left==null&&root.right==null&&root.val==num){
            result.add(new ArrayList<Integer>(path));
        }
        if(root.left!=null&&root.val<=num){
            findPath(root.left,num-root.val);
        }
        if(root.right!=null&&root.val<=num){
            findPath(root.right,num-root.val);
        }
        //移除最后一个元素，遍历完一条路径后要回退，这是关键的地方，遍历到叶节点时发现这条路径不满足要求，那么需要回退到上一个节点
        path.remove(path.size()-1);
        return result;
    }
}
