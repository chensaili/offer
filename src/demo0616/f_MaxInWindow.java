package demo0616;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class f_MaxInWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        if(size<0||num.length==0){
            return null;
        }
        ArrayList<Integer>array=new ArrayList<>();
        if(size==0){
            return array;
        }
        LinkedList<Integer>qmax=new LinkedList<>();
        int left=0;
        while(left<=num.length-size){
            for(int i=left;i<left+size;i++){
                while(!qmax.isEmpty()&&num[i]>num[qmax.peekFirst()]){
                    qmax.pollLast();
                }
                qmax.addLast(i);
            }
            //qmax最上面的元素代表滑动窗口的最大值的索引
            array.add(num[qmax.peekFirst()]);
            //如果qmax最上面的元素位于滑动端口的最左边，那么就要将这个元素去掉，因为再进行一次滑动的窗口不包括这个元素了
            if(qmax.peekFirst()==left) {
                qmax.pollFirst();
            }
            left++;
        }
        return array;
    }
}
