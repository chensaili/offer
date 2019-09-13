package demo0324;
/**
 * 归并排序
 * O(nlgn)
 */
public class F_MergeSort {
    public static void main(String[] args) {
        int[]arr= {7,5,4,6};
        mergeSort(arr,0,arr.length-1);
        for(Integer in:arr) {
            System.out.print(in+" ");
        }
    }
    public static void mergeSort(int[]array,int min,int max){
        if(min==max){
            return;
        }
        //取中间位置元素为基准
        int mid=(min+max)/2;
        //对中间元素的两边都进行归并排序
        mergeSort(array,min,mid);
        mergeSort(array,mid+1,max);
        //将排序好的两边合并
        merge(array,min,mid,max);
    }
    public static void merge(int[]array,int min,int mid,int max){
        //创建一个辅助数组，用来装排序好的元素
        int[]help=new int[max-min+1];//注意大小
        int i=0;//help数组的指针
        int p1=min;//左边数组的指针
        int p2=mid+1;//右边数组的指针
        while(p1<=mid&&p2<=max){
            help[i++]=array[p1]<array[p2]?array[p1++]:array[p2++];
        }
        while(p1<=mid){
            help[i++]=array[p1++];
        }
        while (p2<=max){
            help[i++]=array[p2++];
        }
        //把help数组中的元素复制到arr中
        for(i=0;i<help.length;i++) {
            //注意，这里必须是arr[min+i]，理解看笔记
            array[min+i]=help[i];
        }

    }
}
