package demo0616;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class e_Median {
    public static void main(String[] args) {
        insert(3);
        insert(1);
        insert(6);
        insert(5);
        System.out.println(getMedian());
        insert(2);
        insert(4);
        System.out.println(getMedian());
    }
    static PriorityQueue<Integer>minqueue=new PriorityQueue<>(10,new MinComparator());
    static PriorityQueue<Integer>maxqueue=new PriorityQueue<>(10,new MaxComparator());
    //要保证两个堆的大小之差不大于1
    public static void modifySize(){
        if(minqueue.size()==maxqueue.size()+2) {
            maxqueue.add(minqueue.poll());
        }
        if(maxqueue.size()==minqueue.size()+2) {
            minqueue.add(maxqueue.poll());
        }
    }
    public static void insert(Integer num){
        if(maxqueue.isEmpty()){
            maxqueue.add(num);
        }else if(num<maxqueue.peek()){
            maxqueue.add(num);
        }else {
            minqueue.add(num);
        }
        modifySize();
    }
    public static Double getMedian(){
        if(minqueue.size()>maxqueue.size()) {
            return Double.valueOf(minqueue.peek());
        }else if(minqueue.size()<maxqueue.size()) {
            return Double.valueOf(maxqueue.peek());
        }else {
            return (minqueue.peek()+maxqueue.peek())*1.0/2;
        }
    }
    //小根堆
    public static class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            //升序
            return o1-o2;
        }
    }
    //大根堆
    public static class MaxComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            //降序
            return o2-o1;
        }
    }
}
