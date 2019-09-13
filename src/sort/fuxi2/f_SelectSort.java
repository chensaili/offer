package sort.fuxi2;

public class f_SelectSort {
    public static void selectSort(int[]arr){
        if(arr.length==0){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }
    //两个元素互换
    private static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
