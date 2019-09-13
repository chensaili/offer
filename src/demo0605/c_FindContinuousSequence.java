package demo0605;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照起始数字从小到大的顺序
 */
public class c_FindContinuousSequence {
    public static void main(String[] args) {
    }
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        //设置两个指针指向滑动窗口的头和尾
        int p1=1;
        int p2=2;
        //因为序列相邻的数字是相差1的，所以可以用下面的求和公式
        while(p1<p2){
            int curSum=(p1+p2)*(p2-p1+1)/2;
            if(curSum==sum){
                ArrayList<Integer>list=new ArrayList<>();
                for(int i=p1;i<=p2;i++){
                    list.add(i);
                }
                res.add(list);
                p1++;
            }else if(curSum<sum){
                p2++;
            }else {
                p1++;
            }
        }
        return res;
    }
}
