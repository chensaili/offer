package sort.fuxi;

public class BubbleSort {
    public static void main(String[] args) {
        int[]array={2,1,0,3,5,4,2,1};
        int[]res=bubbleSort(array);
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[] bubbleSort(int[]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }
    public static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
