package demo0324;
/**
 * 冒泡排序
 * 将序列中所有元素两两比较，将最大的放在后面
 * O(n^2)
 */
public class B_BubbleSort {
    public static void main(String[] args) {
        int[]array={5,6,1,4,3};
        int[]res=bubbleSort(array);
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[] bubbleSort(int[]array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
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
