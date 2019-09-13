package demo0616;

import java.util.ArrayList;
import java.util.LinkedList;
//复习
public class MaxInWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        if(size<=0||num.length==0){
            return null;
        }
        //作为返回的结果
        ArrayList<Integer>array=new ArrayList<>();
        //用来装索引
        LinkedList<Integer>qmax=new LinkedList<>();
        int left=0;
        while(left<=num.length-size){
            for(int i=left;i<left+size;i++){
                while(!qmax.isEmpty()&&num[i]>num[qmax.peekFirst()]){
                    qmax.pollFirst();
                }
                qmax.addLast(i);
            }
            array.add(qmax.peekFirst());
            if(qmax.peekFirst()==left){
                qmax.pollFirst();
            }
            left++;
        }
        return array;
    }
}
