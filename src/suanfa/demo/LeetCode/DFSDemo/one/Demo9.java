package suanfa.demo.LeetCode.DFSDemo.one;
/*
 * 有n个盒子排成一行
 * 有n张牌，上面数字分别为1-n
 * 将这n张牌放入n个盒子有多少种放法
 */
//其实就是全排列算法
public class Demo9 {
    public static void main(String[] args) {
        System.out.println(function(4));
    }
    private static int total=0;
    public static int function(int n){
        int[]nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i;
        }
        return count(nums,0,n);
    }
    public static int count(int[]nums,int start,int len){
        if(start==len-1){
            total++;
        }else {
            for(int i=start;i<len;i++){
                swap(nums,start,i);
                count(nums,start+1,len);
                swap(nums,start,i);
            }
        }
        return total;
    }
    public static void swap(int[]strs,int i,int j){
        int temp;
        temp=strs[i];
        strs[i]=strs[j];
        strs[j]=temp;
    }
}
