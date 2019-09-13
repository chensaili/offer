package demo0310;

/**
 * 归并排序
 * O(nlgn)
 */
public class MergeSort {
    public static void main(String[] args) {
        int[]arr= {7,5,4,6};
        mergeSort(arr,0,arr.length-1);
        for(Integer in:arr) {
            System.out.print(in+" ");
        }
    }
    public static void mergeSort(int[]arr,int min,int max) {
        //判断是否只有一个元素
        if(min==max){
            return;
        }
        //不是只有一个元素
        int mid=min+(max-min)/2;
        //以中间元素为基准，对两边元素分别进行归并排序
        mergeSort(arr,min,mid);
        mergeSort(arr,mid+1,max);
        //调用合并的方法，将左右排序好的两个部分进行合并
        merge(arr,min,mid,max);
    }
    public static void merge(int[]arr,int min,int mid,int max){
        int[]help=new int[max-min+1];
        int i=0;//help数组的指针
        int p1=min;//左边数组的指针
        int p2=mid+1;//右边数组的指针
        while (p1<=mid&&p2<=max){
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[i++]=arr[p1++];
        }
        while(p2<=max){
            help[i++]=arr[p2++];
        }
        //把help数组中的元素复制到arr中
        for(i=0;i<help.length;i++) {
            //注意，这里必须是arr[min+i]，理解看笔记
            arr[min+i]=help[i];
        }
    }
}
