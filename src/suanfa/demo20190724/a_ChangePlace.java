package suanfa.demo20190724;

/**
 * 实现一个数组前后两部分换位
 */
public class a_ChangePlace {
    public static void main(String[] args) {
        int[]arr= {0,1,2,3,4,5,6,7};
        //index为分隔的位置
        int index=0;
        change(arr,index);
        for(Integer in:arr) {
            System.out.print(in);
        }
    }
    public static void change(int[]arr,int index){
        if(arr.length<index){
            return;
        }
        //1.前半部分进行倒序
        for(int i=0;i<index&&i<index-i;i++){
            swap(arr,i,index-i);
        }
        //2.后半部分进行倒序
        //i<arr.length-index表示i要小于后半段的长度
        //i<arr.length-index-i表示i小于后半段长度的一半即可
        for(int i=1;i<arr.length-index&&i<arr.length-index-i;i++){
            swap(arr,i+index,arr.length-i);
        }
        //3.整体进行倒序
        for(int i=0;i<arr.length/2;i++){
            swap(arr,i,arr.length-1-i);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp=0;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
