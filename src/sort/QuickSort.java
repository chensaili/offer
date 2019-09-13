package sort;

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
    //选择枢纽元
    private static int getIndex(int[]arr,int low,int high){
        int temp=arr[low];
        while (low<high){
            while (low<high&&arr[high]>=temp){
                high--;
            }
            arr[low]=arr[high];
            while (low<high&&arr[low]<=temp){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=temp;
        return low;
    }
}
