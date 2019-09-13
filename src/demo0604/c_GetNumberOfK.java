package demo0604;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class c_GetNumberOfK {
    public static void main(String[] args) {
        System.out.println(getNumberOfK(new int[]{1,2,2,2,3,4},2));
    }
    public static int getNumberOfK(int[]array,int k){
        return search(array,k+0.5)-search(array,k-0.5);
    }
    private static int search(int[]array,double num){
        int start=0;
        int end=array.length-1;
        while(start<=end){
            int mid=(end+start)/2;
            if(array[mid]<num){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;
    }
}
