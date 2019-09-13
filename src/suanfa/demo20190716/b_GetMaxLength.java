package suanfa.demo20190716;

/**
 * 未排序正数数组中累加和为给定值的最长子数组长度
 * 分析：（1）不能先考虑将数组排序
 *       （2）如果找到了一组符合要求的子数组，那么在right不大于等于数组长度的前提下，需要继续考察left索引之后的子数组
 *           （体现在sum-=arr[left++]语句上面）
 *       （3）只要在sum==k的条件下再加上语句res++，那么就可以得到在整个数组中有多少组和为k的子数组
 * break--退出while循环，但while循环后面还有其他语句的话，还是会执行，
 * continue--退出当次while，会接着从while循环的开始部分重新执行下来，
 * return--退出函数，while循环后面还有其他语句的话，直接跳过不会执行
 */
public class b_GetMaxLength {
    public static void main(String[] args) {
        int[]arr=new int[]{1,2,1,1,1};
        System.out.println(getMaxLength(arr,3));
    }
    public static int getMaxLength(int[]arr,int k){
        if(arr==null||arr.length==0||k<0){
            return 0;
        }
        int left=0;//代表数组最左端的索引
        int right=0;//代表数组最右端的索引
        int sum=arr[0];
        int len=0;//最长子数组的长度
        //int res=0;
        while(right<arr.length){
            if(sum==k){
                //res++;
                len=Math.max(len,right-left+1);
                sum-=arr[left++];
            }else if(sum<k){
                right++;
                //需要判断是否超界
                if(right==arr.length){
                    break;
                }
                sum+=arr[right];
            }else {
                sum-=arr[left++];
            }
        }
        return len;
    }
}
