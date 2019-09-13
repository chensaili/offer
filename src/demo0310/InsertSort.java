package demo0310;

/**
 * 插入排序
 * O(n^2)
 */
public class InsertSort {
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
            for(int j=i;j>0&&array[j]<array[j-1];j--){
                int temp=array[j];
                array[j]=array[j-1];
                array[j-1]=temp;
            }
        }
        return array;
    }

}
