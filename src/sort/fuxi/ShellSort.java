package sort.fuxi;

public class ShellSort {
    public static void main(String[] args) {
        int[]array={2,1,0,3,5,4,2,1};
        int[]res=shellSort(array);
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[] shellSort(int[]arr){
        int len=arr.length;
        int incrment=len/3+1;
        while(incrment>1){
            for(int i=incrment;i<len;i++){
                int j=i;
                while (j>=incrment&&arr[j-incrment]>arr[j]){
                    int temp=arr[j-incrment];
                    arr[j-incrment]=arr[j];
                    arr[j]=temp;
                    j=j-incrment;
                }
            }
            incrment=incrment/3+1;
        }
        return arr;
    }
}
