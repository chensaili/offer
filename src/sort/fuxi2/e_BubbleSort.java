package sort.fuxi2;
//两两比较
public class e_BubbleSort {
    public static void main(String[] args) {

    }
    public static void bubbleSort(int[]arr){
        if(arr.length==0){
            return;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]) {
                    swap(arr, j, j + 1);
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
