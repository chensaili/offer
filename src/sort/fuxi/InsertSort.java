package sort.fuxi;

public class InsertSort {
    public static void main(String[] args) {
        int[]array={2,1,0,3,5,4,2,1};
        int[]res=insertSort(array);
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[]insertSort(int[]arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0&&arr[j]<arr[j-1];j--){
                swap(arr,j,j-1);
            }
        }
        return arr;
    }
    private  static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
