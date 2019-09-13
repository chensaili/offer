package suanfa.demo20190716;

import java.util.HashMap;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度(路径是指从某个节点往下，不一定是从根节点开始)
 */
public class a_GetMaxLength {
    public static void main(String[] args) {

    }
    public static int getMaxLength(TreeNode node,int sum){
        //key代表某个累加和，value值代表这个累加和在路径中最早出现的层数
        HashMap<Integer,Integer>sumMap=new HashMap<>();
        //注意put进去的是（0,0），数组的时候是（0，-1）
        sumMap.put(0,0);
        //下面这个1表示的是根节点的高度
        return preOrder(node,sum,0,1,0,sumMap);
    }
    public static int preOrder(TreeNode head,int sum,int preSum,int level,
                               int maxLen,HashMap<Integer,Integer>sumMap){
        if(head==null){
            return maxLen;
        }
        int curSum=preSum+head.value;
        if(!sumMap.containsKey(curSum)){
            sumMap.put(curSum,level);
        }
        if(sumMap.containsKey(sum-curSum)){
            maxLen=Math.max(maxLen,level-sumMap.get(curSum-sum));
        }
        maxLen=preOrder(head.left,sum,curSum,level+1,maxLen,sumMap);
        maxLen=preOrder(head.right,sum,curSum,level+1,maxLen,sumMap);
        if(level==sumMap.get(curSum)){
            sumMap.remove(curSum);
        }
        return maxLen;
    }
}
