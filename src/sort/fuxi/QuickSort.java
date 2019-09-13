package sort.fuxi;

public class QuickSort {
    public static void main(String[] args) {
        int[]array={4,2,1,0,6,3,8};
        quickSort(array,0,array.length-1);
        for(int in:array){
            System.out.print(in+" ");
        }
    }
    public static void quickSort(int[]arr,int low,int high){
        if(low<high){
            int index=getIndex(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }
    public static int getIndex(int[]arr,int low,int high){
        int temp=arr[low];
        while(low<high){
            while (low<high&&arr[high]>temp){
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
