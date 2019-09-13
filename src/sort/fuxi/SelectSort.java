package sort.fuxi;

public class SelectSort {
    public static void main(String[] args) {
        int[]array={2,1,0,3,5,4,2,1};
        int[]res=selectSort(array);
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[] selectSort(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    swap(arr,i,j);
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
