package suanfa.demo3;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈基本功能的基础上，再实现返回栈中最小元素的功能
 * 要求pop，push，getMin操作的时间复杂度都是O(1)
 */
public class c_GetStackMin {
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        System.out.println(myStack.getMin());
        myStack.pop();
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.getMin());
    }
    public static class MyStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackmin;
        public MyStack(){
            this.stackData=new Stack<Integer>();
            this.stackmin=new Stack<Integer>();
        }
        //往栈中存入数据
        public void push(int newNum){
            //往data栈中存入数据
            stackData.push(newNum);
            //往min栈中存入数据
            if(stackmin.isEmpty()){
                stackmin.push(newNum);
            }else if(getMin()>newNum){
                stackmin.push(newNum);
            }else {
                int newMin=stackmin.peek();
                stackmin.push(newMin);
            }
        }
        //从栈中取出数据
        public int pop(){
            if(stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            stackmin.pop();
            return stackData.pop();
        }
        //取出栈的最小值
        public int getMin(){
            if(stackmin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return stackmin.peek();
        }
    }
}
