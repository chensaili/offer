package demo0310;

/**
 * 冒泡排序
 * O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[]array={2,1,0,3,5};
        int[]res=bubbleSort(array);
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[] bubbleSort(int[]array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }
}
