package suanfa.demo.LeetCode.DFSDemo.one;
//寻找满足ABC+DEF=GHI的情况有多少，比如173+286=459
// 其中这9个字母每个范围是都是在1~9之间，且不重复，每个数字仅此出现一次
public class Demo10 {

    public static void main(String[] args) {
        System.out.println(function(9));
    }

    private static int total=0;
    public static int function(int n){
        int[]nums=new int[10];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        return count(nums,0,n);
    }
    public static int count(int[]nums,int start,int len){
        if(start==len-1){
            if(nums[0]*100+nums[1]*10+nums[2]*1+nums[3]*100+nums[4]*10+nums[5]*1
                    ==nums[6]*100+nums[7]*10+nums[8]){
                System.out.println(nums[0]+" "+nums[1]+" "+nums[2]+"+"+nums[3]+" "+nums[4]+" "+nums[5]+"="+nums[6]+" "+nums[7]+" "+nums[8]);
                total++;
            }
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
