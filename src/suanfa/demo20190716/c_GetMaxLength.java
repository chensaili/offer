package suanfa.demo20190716;

import java.util.HashMap;

/**
 * 未排序数组（元素可正可负可零）中累加和为给定值的最长子数组长度
 */
public class c_GetMaxLength {
    public static void main(String[] args) {
        int[]arr=new int[]{3,-1,2,1};
        System.out.println(getMaxLength(arr,2));
    }
    public static int getMaxLength(int[]arr,int k){
        if(arr.length==0||arr==null){
            return 0;
        }
        //key表示从数组最左边开始累加过程中出现过的sum值
        //value表示sum值最早出现的位置（索引）
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);//最关键的地方
        int len=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                len=Math.max(i-map.get(sum-k),len);
            }
            //map只记录sum值第一次出现的索引
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }
}
