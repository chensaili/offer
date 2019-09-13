package demo0516fuxi;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 */
public class e_TwoStackToQueue {
    public static void main(String[] args) {
        e_TwoStackToQueue e=new e_TwoStackToQueue();
        e.push(1);
        e.push(2);
        e.push(3);
        e.push(4);
        System.out.println(e.pop());
        System.out.println(e.pop());
    }
    static Stack<Integer> stack1=new Stack<>();
    static Stack<Integer> stack2=new Stack<>();
    //push操作
    public void push(Integer in){
        stack1.push(in);
    }
    /**
     * pop操作
     * 两个原则：
     * 当stack2里没有元素时才可以往里面放元素
     * 往stack2里放元素后就要把stack1里的元素全部放进去
     */
    public int pop(){
        if(stack1.isEmpty()&&stack2.isEmpty()){
            throw new RuntimeException();
        }
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
