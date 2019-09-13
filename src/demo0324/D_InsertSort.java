package demo0324;
/**
 * 插入排序
 * 在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，
 * 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序
 * O(n^2)
 */
public class D_InsertSort {
    public static void main(String[] args) {
        int[]array={2,1,0,3,5};
        int[]res=insertSort(array);
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[] insertSort(int[]array){
        if(array.length==0){
            return array;
        }
        for(int i=1;i<array.length;i++){
            //插入排序的主要体现就是在j--上面
            for(int j=i;j>0&&array[j]<array[j-1];j--){
                swap(array,j,j-1);
            }
        }
        return array;
    }
    private static void swap(int[]array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
