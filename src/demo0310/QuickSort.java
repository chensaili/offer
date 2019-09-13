package demo0310;

/**
 * 快速排序
 * O(nlgn)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[]array={4,2,1,7,5,0,6,3,8};
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
    //获得基准数据的索引
    public static int getIndex(int[]array,int low,int high){
        int tmp=array[low];//基准数据
        while(low<high){
            //1.当队尾的元素大于等于基准数据时，向前挪动high指针
            while(low<high&&array[high]>=tmp){
                high--;
            }
            //2.当队尾元素小于基准元素时，就将此时的high值赋值个low值
            array[low]=array[high];
            //3.当队首元素小于等于tmp时,向后挪动low指针
            while(low<high&&array[low]<=tmp){
                low++;
            }
            //4.当队首元素大于tmp时,需要将其赋值给high
           array[high] = array[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        array[low]=tmp;
        return low;
    }
}
