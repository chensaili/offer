package suanfa.demo2;

/**
 * 桶排序
 */
public class a_BucketSort {
    public static void main(String[] args) {
        int[]arr= {3,2,4,2,1,10,2,6,7,4};
        bucketSort(arr);
        for(Integer in:arr) {
            System.out.print(in+" ");
        }
    }
    public static void bucketSort(int[]arr){
        if(arr==null||arr.length==1){
            return;
        }
        //1.获取数组的最大值
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //2.创建一个桶，桶大小为数组最大值+1
        int[]bucket=new int[max+1];
        for(int i=0;i<arr.length;i++){
            bucket[arr[i]]++;
        }
        //3.从bucket中取出数据
        int i=0;
        for(int j=0;j<bucket.length;j++){
            while (bucket[j]-->0){
                arr[i++]=j;
            }
        }
    }
}
