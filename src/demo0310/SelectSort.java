package demo0310;

/**
 * 选择排序
 * O(n^2)
 */
public class SelectSort {
    public static void main(String[] args) {
        int[]array={2,1,0,3,5};
        int[]res=selectSort(array);
        for(int in:res){
            System.out.print(in+" ");
        }
    }
    public static int[] selectSort(int[]array){
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
}
