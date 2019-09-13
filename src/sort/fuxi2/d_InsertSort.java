package sort.fuxi2;

public class d_InsertSort {
    public int[] insertSort(int[]arr){
        if(arr.length==0){
            return arr;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0&&arr[j]<arr[j-1];j--){
                swap(arr,j,j-1);
            }
        }
        return arr;
    }
    //两个元素互换
    private void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
