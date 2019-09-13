package sort.fuxi2;
//归并排序，稳定，NlogN，采用递归，分而治之
public class a_MergeSort {
    public static void main(String[] args) {
        int[]arr= {7,5,4,6,1,3};
        mergeSort(arr,0,arr.length-1);
        for(Integer in:arr) {
            System.out.print(in+" ");
        }
    }
    public static void mergeSort(int[]arr,int min,int max){
        if(min==max){
            return;
        }
        //以中间元素为基准，对两边的元素进行递归排序
        int mid=(min+max)/2;
        mergeSort(arr,min,mid);
        mergeSort(arr,mid+1,max);
        //将排序好的左右两部分进行合并
        merge(arr,min,mid,max);
    }
    //对两边的元素进行合并
    public static void merge(int[]arr,int min,int mid,int max){
        int[]res=new int[max-min+1];//创建一个新数组存放结果
        int i=0;
        int p1=min;//左边数组的第一个元素的索引
        int p2=mid+1;//右边数组的第一个元素的索引
        while(p1<=mid&&p2<=max){
            res[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            res[i++]=arr[p1++];
        }
        while (p2<=max){
            res[i++]=arr[p2++];
        }
        //把res数组的元素复制到arr中
        for(i=0;i<res.length;i++){
            arr[i+min]=res[i];
        }
    }
}
