package demo0308;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
    public static void main(String[] args) {
        int[] pushA={1,2,3,4,5};
        int[]popA={5,4,3,2,1};
        System.out.println(isPopOrder(pushA,popA));
    }
    public static boolean isPopOrder(int[] pushA,int[] popA){
        Stack<Integer>stack=new Stack<>();
        int popAindex=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            //不能忘记!stack.isEmpty()，否则stack.peek()会出现空指针异常
            while (!stack.isEmpty()&&stack.peek()==popA[popAindex]){
                stack.pop();
                popAindex++;
            }
        }
        return stack.isEmpty();
    }
}
