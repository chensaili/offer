package sort;

public class HeapSort {
    public static void main(String[] args) {
        int[]arr={3,1,6,4,7,5,8,0,9};
        //1.建立大根堆
        for(int i=0;i<arr.length;i++){
            insert(arr,i);
        }
        //打印大根堆数组
        for(Integer in:arr) {
            System.out.print(in+" ");
        }
        //换行
        System.out.println();
        //2.堆的减小
        int heapSize=arr.length;
        //(1)将堆顶元素和最后一个元素互换位置
        swap(arr,0,--heapSize);//此时的heapSize比原来已经小1了，因为进行了自减操作
        //(2)进行堆的减小
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
        //左节点的index
        int left=2*index+1;
        while(left<heapSize){
            //找出左右节点和根节点中最大的那个节点
            int largest=left+1<heapSize&&arr[left+1]>arr[left]?left+1:left;
            largest=arr[largest]>arr[index]?largest:index;
            //根节点比左右节点都大
            if(largest==index){
                break;
            }
            swap(arr,index,largest);
            //关键，下滤
            index=largest;
            left=index*2+1;
        }
    }
    //建立大根堆
    public static void insert(int[]arr,int index){
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            //关键，上滤
            index=(index-1)/2;
        }
    }

    //两个元素互换
    private  static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
