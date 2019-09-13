package suanfa.demo20190716;

import java.util.HashMap;

/**
 * 未排序数组（元素可正可负可零）中累加和为给定值的最长子数组长度
 */
public class cc_GetMaxLength {
    public static void main(String[] args) {

    }
    public static int getMaxLength(int[]array,int k){
        if(array.length==0||array==null){
            return 0;
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int len=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
            if(map.containsKey(sum-k)){
                len=Math.max(i-map.get(sum-k),len);
            }
            //记录sum值第一次出现的地方
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }
}
