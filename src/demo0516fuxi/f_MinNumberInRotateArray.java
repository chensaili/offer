package demo0516fuxi;
/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 */
public class f_MinNumberInRotateArray {
    public static void main(String[] args) {
        int[]arr={1,1,1,0,1};
        System.out.println(minNumberInRotateArray(arr));
    }
    public static int minNumberInRotateArray(int[]arr){
        if(arr.length<0){
            return 0;
        }
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(arr[low]>=arr[high]){
            //分界点
            if(high-low==1){
                //关键
                mid=high;
                break;
            }
            mid=(low+high)/2;

            if(arr[low]==arr[mid]&&arr[mid]==arr[high]){
                //当三者都相等时，无法确定中间元素属于前面还是后面的递增数组，只能顺序查找
                return findMin(arr,low,high);
            }

            if(arr[mid]>=arr[low]){
                //中间元素位于前面的递增子数组,此时最小元素位于中间元素的后面
                low=mid;
            }else {
                //中间元素位于后面的递增子数组,此时最小元素位于中间元素的前面
                high=mid;
            }
        }

        return arr[mid];
    }
    public static int findMin(int[]arr,int low,int high){
        int min=arr[low];
        for(int i=low+1;i<high;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
}
