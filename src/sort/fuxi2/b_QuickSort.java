package sort.fuxi2;

/**
 * 不稳定，额外空间复杂度O（N）
 */
public class b_QuickSort {
    public static void main(String[] args) {

    }
    public static void quickSort(int[]array,int low,int high){
        if(low<high) {
            //找到基准元素的索引
            int index=getIndex(array,low,high);
            quickSort(array,low,index);
            quickSort(array,index+1,high);
        }
    }
    public static int getIndex(int[]array,int low,int high){
        int temp=array[low];
        while(low<high){
            while(low<high&&array[high]>=temp){
                high--;
            }
            array[low]=array[high];
            while ((low<high&&array[low]<temp)){
                low++;
            }
            array[high]=array[low];
        }
        array[low]=temp;
        return low;
    }
}
