package sort.fuxi2;

public class c_HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 6, 4, 7, 5, 8, 0, 9};
        heapSort(arr);
        for(int ch:arr) {
            System.out.print(ch+" ");
        }
    }
    public static void heapSort(int[]chars){
        for(int i=0;i<chars.length;i++){
            function1(chars,i);
        }

        for(int i=chars.length-1;i>0;i--){
            swap(chars,0,i);
            function2(chars,0,i);
        }

    }
    public static void heapInsert(int[]chars,int index){
        while(chars[index]>chars[(index-1)/2]){
            swap(chars,index,(index-1)/2);
            //上浮
            index=(index-1)/2;
        }
    }

    public static void heaplify(int[]chars,int index,int heapSize){
        //index为根节点的索引
        int left=2*index+1;
        while(left<heapSize){
            int largest=left+1<heapSize&&chars[left+1]>chars[left]?left+1:left;
            largest=chars[largest]>chars[index]?largest:index;
            if(largest==index){
                break;
            }
            swap(chars,index,largest);
            //下沉
            index=largest;
            left=index*2+1;
        }
    }
    //两个元素互换
    private  static void swap(int[]chars,int i,int j){
        int temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }

    //下面是复习的
    //建立大根堆
    public static void function1(int[]chars,int index){
        while(chars[index]>chars[(index-1)/2]){
            swap(chars,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    //减小大根堆
    public static void function2(int[]chars,int index,int heapSize){
        int left=2*index+1;
        while(left<heapSize){
            int largest=left+1<heapSize&&chars[left]<chars[left+1]?left+1:left;
            largest=chars[index]>chars[largest]?index:largest;
            if(largest==index){
                break;
            }
            swap(chars,index,largest);
            //下沉
            index=largest;
            left=index*2+1;
        }
    }
}
