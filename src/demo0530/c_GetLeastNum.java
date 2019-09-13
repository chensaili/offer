package demo0530;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 思路：用最大根堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
 */
public class c_GetLeastNum {
    public static void main(String[] args) {
        int[]array={5,7,0,6,8};
    }
    /*public static ArrayList<Integer>findNum(int[]array){
        //建立大根堆
        for(int i=0;i<array.length;i++){
            insert(array,i);
        }
        return null;
    }
    //建立大根堆
    private static void insert(int[]array,int index){
        while(array[index]>array[(index-1)/2]){
            int temp=array[index];
            array[index]=array[(index-1)/2];
            array[(index-1)/2]=temp;
            index=(index-1)/2;
        }
    }*/
    public static ArrayList<Integer> findNum(int[]array,int k){
        ArrayList<Integer>res=new ArrayList<>();
        int len=array.length;
        if(k>len||k==0){
            return res;
        }
        //优先级队列
        PriorityQueue<Integer>maxHeap=new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);//升序
            }
        });
        for(int i=0;i<len;i++){
            if(maxHeap.size()!=k){
                maxHeap.offer(array[i]);
            }else if(maxHeap.peek()>array[i]){
                Integer temp=maxHeap.poll();
                temp=null;//为了GC
                maxHeap.offer(array[i]);
            }
        }
        for(Integer integer:maxHeap){
            res.add(integer);
        }
        return res;
    }

}
