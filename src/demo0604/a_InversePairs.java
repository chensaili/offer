package demo0604;

import java.util.HashMap;
import java.util.Map;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P
 * 利用归并排序的思想
 */
public class a_InversePairs {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,0};
        System.out.println(inversePairs(array));
    }
    static int count=0;
    public static int inversePairs(int[]array){
        if(array.length!=0){
            mergeSort(array,0,array.length-1);
        }
        return count;
    }
    public static void mergeSort(int[]array,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }
    public static void merge(int[]arr,int start,int mid,int end){
        //创建一个新的数组,用来存放排序好的结果
        int[]result=new int[end-start+1];
        //创建三个变量，表示temp，左数组和右数组的位置
        int i=0;
        int p1=start;
        int p2=mid+1;
        while(p1<=mid&&p2<=end){
            //result[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
            if(arr[p1]<=arr[p2]){
                result[i++]=arr[p1++];
            }else {
                result[i++]=arr[p2++];
                //因为当前面的数组值array[p1]大于后面数组值array[p2]时；
                // 则前面数组array[p1]~array[mid]多个元素都是大于array[p2]的
               count=count+mid-p1+1;
            }
        }
        while(p1<=mid){
            result[i++]=arr[p1++];
        }
        while(p2<=end){
            result[i++]=arr[p2++];
        }
        //把result数组中的元素复制到arr中
        for(i=0;i<result.length;i++) {
            arr[start+i]=result[i];
        }
    }
}
