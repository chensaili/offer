package demo0324;
/**
 * 选择排序
 * 遍历整个序列，将最小的数放在最前面，遍历剩下的序列，将最小的数放在最前面，直到只剩下一个数。
 * O(n^2)
 */
public class A_SelectSort {
    public static void main(String[] args) {
        int[]array={2,1,0,3,5};
        int[]res=sort(array);
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[] sort(int[]array){
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    swap(array,i,j);
                }
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
