package sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[]array={2,1,0,3,5};
        int[]res=sort(array);
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[] sort(int[]arr){
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
    private  static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
