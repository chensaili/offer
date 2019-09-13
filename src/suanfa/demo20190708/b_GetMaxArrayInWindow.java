package suanfa.demo20190708;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 */
public class b_GetMaxArrayInWindow {
    public static void main(String[] args) {
        int[]arr=new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer>res=getMaxArray(arr,3);
        for(Integer in:res){
            System.out.print(in+" ");
        }
    }
    public static ArrayList<Integer> getMaxArray(int[]arr, int w){
        if(arr==null||w<1||w>arr.length){
            return null;
        }
        //如果数组的长度为n，窗口的大小为w，那么一共产生n-w+1个窗口的最大值
        ArrayList<Integer>array=new ArrayList<>();
        LinkedList<Integer>qmax=new LinkedList<>();//队首位置存放的是最大值的索引
        int left=0;
        while(left<=arr.length-w){
            for(int i=left;i<left+w;i++){
                while(!qmax.isEmpty()&&arr[i]>=arr[qmax.peekFirst()]){
                    qmax.pollLast();
                }
                qmax.addLast(i);
            }
            array.add(arr[qmax.peekFirst()]);
            if(qmax.peekFirst()==left) {
                qmax.pollFirst();
            }
            left++;
        }
        return array;
    }
}
