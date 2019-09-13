package demo0306;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class TwoStackToQueue {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    public void push(Integer in){
        stack1.push(in);
    }
    public int pop(){
        if(stack1.isEmpty()&&stack2.isEmpty()){
            throw new RuntimeException();
        }
        /**
         * 两个原则：
         * 当stack2里没有元素时才可以往里面放元素
         * 往stack2里放元素后就要把stack1里的元素全部放进去
         */
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
