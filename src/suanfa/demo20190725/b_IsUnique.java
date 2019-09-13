package suanfa.demo20190725;


/**
 * 判断字符数组中是否所有的字符都只出现过一次
 * 要求是额外空间复杂度是O(1)，时间复杂度尽量低
 */
public class b_IsUnique {
    public static void main(String[] args) {
        int[]chars=new int[]{2,3,1,4,2,5,3};
        heapSort(chars);
        for(int ch:chars) {
            System.out.print(ch+" ");
        }
        System.out.println(isUnique1(chars));
    }
    public static boolean isUnique1(int[]chars){
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void heapSort(int[]chars){
        for(int i=0;i<chars.length;i++){
            heapInsert(chars,i);
        }

        for(int i=chars.length-1;i>0;i--){
            swap(chars,0,i);
            heaplify(chars,0,i);
        }

    }
    public static void heapInsert(int[]chars,int index){
        while(chars[index]>chars[(index-1)/2]){
            swap(chars,index,(index-1)/2);
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
}
