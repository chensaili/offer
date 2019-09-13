package demo0310;

/**
 * 堆排序
 * O(nlgn)
 */
public class HeapSort {
    public static void main(String[] args) {
        int[]arr={5,7,0,6,8,10,9};
        if(arr==null||arr.length<2){
            return;
        }
        //将数组形成大根堆的形式
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        for(Integer in:arr) {
            System.out.print(in+" ");
        }
        System.out.println();
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
    public static void heaplify(int[]arr,int index,int heapSize){
        int left=index*2+1;//左节点的index
        while(left<heapSize){
            //找出左右节点和根节点中最大的那个节点
            int largest=left+1<heapSize&&arr[left+1]>arr[left]?left+1:left;
            largest=arr[largest]>arr[index]?largest:index;
            if(largest==index){
                //根节点比左右节点都大
                break;
            }
            swap(arr,index,largest);
            //关键
            index=largest;
            left=index*2+1;
        }

    }
    //堆的扩大，即形成大根堆
    public static void heapInsert(int[]arr,int index){
        while(arr[index]>arr[(index-1)/2]){
            //子节点index大于父节点(index-1)/2，两者互换
            swap(arr,index,(index-1)/2);
            //这一步是为了把换到父节点的元素继续与父节点的父节点比较大小
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
