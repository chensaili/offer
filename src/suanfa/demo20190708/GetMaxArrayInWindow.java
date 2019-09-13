package suanfa.demo20190708;

import java.util.ArrayList;
import java.util.LinkedList;

public class GetMaxArrayInWindow {
    public static void main(String[] args) {
        int[]arr=new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer>res=getMaxArrayInWindow(arr,3);
        for(Integer in:res){
            System.out.print(in+" ");
        }
    }
    public static ArrayList<Integer> getMaxArrayInWindow(int[]array,int k){
        if(array==null||k<1||k>array.length){
            return null;
        }
        ArrayList<Integer>res=new ArrayList<>();//存放结果
        LinkedList<Integer>qmax=new LinkedList<>();//这个链表的第一个位置存放的是窗口内最大值的索引
        int left=0;
        while(left<=array.length-k){
            for(int i=left;i<k+left;i++){
                if(qmax.isEmpty()){
                    //如果链表中没有元素，那么直接将当前索引压入链表
                    qmax.add(i);
                }
                while(!qmax.isEmpty()&&array[i]>array[qmax.peekFirst()]){
                    //如果链表不为空，并且当前索引对应的数组的元素比链表的第一个元素还要大，那么将链表中的全部元素弹出,然后再将当前索引放入链表
                    qmax.pollLast();
                }
                qmax.addLast(i);
            }
            res.add(array[qmax.peekFirst()]);
            if(left==qmax.peekFirst()){
                qmax.pollFirst();
            }
            left++;
        }
        return res;
    }
}
