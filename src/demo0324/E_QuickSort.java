package demo0324;
/**
 * 快速排序
 * 选择第一个数为p,小于p的数放在左边，大于p的数放在右边，
 * 递归的将p左边和右边的数都按照第一步来，直到不能递归
 * O(nlgn)
 */
public class E_QuickSort {
    public static void main(String[] args) {
        int[]array={3,1,6,2,5};
        quickSort(array,0,array.length-1);
        for(int in:array){
            System.out.print(in+" ");
        }
    }
    public static void quickSort(int[]array,int low,int high){
        if(low<high){
            int index=getIndex(array,low,high);
            quickSort(array,low,index-1);
            quickSort(array,index+1,high);
        }
    }
    //获取基准元素的位置
    public static int getIndex(int[]array,int low,int high){
        int tmp=array[low];//基准数据
        while(low<high){
            while(low<high&&array[high]>=tmp){
                high--;
            }
            array[low]=array[high];
            while(low<high&&array[low]<=tmp){
                low++;
            }
            array[high] = array[low];
        }
        array[low]=tmp;
        return low;
    }
}
