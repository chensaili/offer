package suanfa.demo20190709;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    public static void reverse(Stack<Integer>stack){
        if(stack.isEmpty()||stack.size()==1){
            return ;
        }
        int i=getLast(stack);
        reverse(stack);
        stack.push(i);
    }
    //获取栈底元素
    public static int getLast(Stack<Integer>stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            int last = getLast(stack);
            stack.push(res);
            return last;
        }
    }
}
