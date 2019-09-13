package sort.fuxi;

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
        int mid=(min+max)/2;
        mergeSort(arr,min,mid);
        mergeSort(arr,mid+1,max);
        merge(arr,min,mid,max);
    }
    public static void merge(int[]arr,int min,int mid,int max){
        int[]res=new int[max-min+1];
        int i=0;
        int p1=min;
        int p2=mid+1;
        while(p1<=mid&&p2<=max){
            res[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            res[i++]=arr[p1++];
        }
        while(p2<=max){
            res[i++]=arr[p2++];
        }
        for(i=0;i<res.length;i++){
            arr[i+min]=res[i];
        }
    }
}
