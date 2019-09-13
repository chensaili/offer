package sort;

public class MergeSort {
    public static void main(String[] args) {
        int[]arr= {7,5,4,6,1,3};
        mergeSort(arr,0,arr.length-1);
        for(Integer in:arr) {
            System.out.print(in+" ");
        }
    }
    public static void mergeSort(int[]arr,int min,int max){
        if(max==min){
            return;
        }
        //如果数组的长度大于1，那么以中间元素为基准，对两边元素分别进行递归
        int mid=(min+max)/2;
        mergeSort(arr,min,mid);
        mergeSort(arr,mid+1,max);
        //调用合并的方法，将左右两边排序好的两个部分进行合并
        merge(arr,min,mid,max);
    }
    public static void merge(int[]arr,int min,int mid,int max){
        //创建一个新的数组,用来存放排序好的结果
        int[]result=new int[max-min+1];
        //创建三个变量，表示temp，左数组和右数组的位置
        int i=0;
        int p1=min;
        int p2=mid+1;
        while(p1<=mid&&p2<=max){
            result[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            result[i++]=arr[p1++];
        }
        while(p2<=max){
            result[i++]=arr[p2++];
        }
        //把result数组中的元素复制到arr中
        for(i=0;i<result.length;i++) {
            arr[min+i]=result[i];
        }
    }
}
