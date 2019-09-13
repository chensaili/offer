package suanfa.demo1;
/**
 * 实现一个数组前后两部分换位
 * 如1 2 3 4 5转换为4 5 1 2 3
 * 第一步：前后两部分分别倒序 得3 2 1 5 4
 * 第二步：将第一步得到的数组整体倒序 4 5 1 2 3
 */

public class a_ChangePlace {
    public static void main(String[] args) {
        int[]arr= {1,2,3,4,5};
        //index为分隔的位置
        int index=2;
        change(arr,index);
        for(Integer in:arr) {
            System.out.print(in);
        }
    }
    public static void change(int[]array,int index){
        for(int i=0;i<index&&i<index-i;i++){//i<index-i用来保证i只到前半部分的前一半
            swap(array,i,index-i);
        }
        for(int i=1;i<array.length-index&&i+index<array.length-i;i++){//i+index<array.length-i用来保证i只到后半部分的前一半
            swap(array,index+i,array.length-i);
        }
        for(int i=0;i<array.length/2;i++) {
            swap(array,i,array.length-1-i);
        }
    }
    //创建元素互换方法
    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
