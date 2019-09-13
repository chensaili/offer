package suanfa.demo20190716;

import java.util.HashMap;

public class aa_GetMaxLength {
    public static void main(String[] args) {

    }
    public static int getMaxLength(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,0);
        return preOrder(root,sum,0,1,0,map);
    }
    //先序遍历
    public static int preOrder(TreeNode root,int sum,int preSum,int level,
                                int maxLen,HashMap<Integer,Integer>sumMap){
        if(root==null){
            return maxLen;
        }
        int curSum=preSum+root.value;
        if(!sumMap.containsKey(curSum)){
            sumMap.put(curSum,level);
        }
        if(sumMap.containsKey(sum-curSum)){
            maxLen=Math.max(maxLen,level-sumMap.get(curSum-sum));
        }
        maxLen=preOrder(root.left,sum,curSum,level+1,maxLen,sumMap);
        maxLen=preOrder(root.right,sum,curSum,level+1,maxLen,sumMap);
        if(level==sumMap.get(curSum)){
            sumMap.remove(curSum);
        }
        return maxLen;
    }
}
