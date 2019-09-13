package demo0324;
/**
 * 堆排序
 * O(nlgn)
 */
public class C_HeapSort {
    public static void main(String[] args) {
        int[]arr={5,7,0,6,8,10,9};
        if(arr==null||arr.length<2){
            return;
        }
        //将数组形成大根堆的形式
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        //堆的大小
        int heapSize=arr.length;
        //将堆顶元素和堆的最后一个元素互换
        // 互换后，将堆的最后一个元素排序在外，即减小堆的大小
        swap(arr,0,--heapSize);
        while (heapSize>0){
            heaplify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
        for(Integer in:arr) {
            System.out.print(in+" ");
        }
    }
    //堆的减小
    public  static void heaplify(int[]arr,int index,int heapSize){
        //左节点的index
        int left=index*2+1;
        while (left<heapSize){
            //找出左节点右节点和根节点中最大的节点
            int largest=left+1<heapSize&&arr[left+1]>arr[left]?left+1:left;
            largest=arr[largest]>arr[index]?largest:index;
            if(largest==index){
                break;
            }
            swap(arr,index,largest);
            //下面的代码是确保与跟节点更换位置的那边依旧是大根堆
            index=largest;
            left=index*2+1;
        }
    }
    //堆的扩大
    public static void heapInsert(int[]array,int index){
        while(array[(index-1)/2]<array[index]){
            //当子结点大于根结点时，互换位置
            swap(array,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    //创建元素互换方法
    private static void swap(int[] arr, int i, int j) {
        int temp=0;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
