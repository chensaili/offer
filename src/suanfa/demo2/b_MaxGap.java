package suanfa.demo2;

/**
 * 将一个无序数组排序后，返回最大的相邻两数之间的插值
 */
public class b_MaxGap {
    public static void main(String[] args) {
        int[]nums= {32,1,15,9};
        int maxgap=maxGap(nums);
        System.out.println(maxgap);
    }
    public static int maxGap(int[]nums) {
        if(nums==null||nums.length<2){
            return 0;
        }
        //len是为了创建数组而用
        int len = nums.length;
        //遍历获得数组的最大值和最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        //创建三个数组,长度都为len+1
        boolean[]hasnum=new boolean[len+1];//代表第i个桶是否有数
        int[]maxs=new int[len+1];//第i位代表第i个桶的最大数
        int[]mins=new int[len+1];//第i位代表第i个桶的最小数
        int bid=0;//bid为桶编号
        for(int i=0;i<nums.length;i++){
            //调用方法bucket得到该数据放入第几号桶
            bid=bucket(nums[i],len,min,max);
            //得到第bid号桶的最大值和最小值
            mins[bid]=hasnum[i]?Math.min(mins[i],nums[i]):nums[i];
            maxs[bid]=hasnum[i]?Math.max(maxs[i],nums[i]):nums[i];
            //经过上面操作那么第bid号桶肯定有数据，故将其改为true
            hasnum[bid]=true;
        }
        //计算相邻桶之间右桶的最小值减左桶最大值的大小
        int res=0;
        int lastMax=maxs[0];
        for(int i=1;i<=len;i++){
            //如果第i个桶有数
            if(hasnum[i]){
                res=Math.max(res,mins[i]-lastMax);
                lastMax=maxs[i];
            }
        }
        return res;
    }
    //根据数据，数组长度，数组的最大值和最小值可以确定该数据应该放在第几号桶中
    public static int bucket(int num,int len,int min,int max) {
        return (int)((num-min)*len/(max-min));
    }
}
