package suanfa.demo20190709;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈
 * 这个题目很陌生
 */
public class a_ReverseStack {
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
        if(stack.isEmpty()){
            return;
        }
        int i=getAndRemoveElement(stack);
        reverse(stack);
        stack.push(i);
    }
    //创建方法，将stack的栈底元素返回并移除
    public static int getAndRemoveElement(Stack<Integer>stack){
        int res=stack.pop();
        if(stack.isEmpty()){
            return res;
        }else {
            int last=getAndRemoveElement(stack);
            stack.push(res);
            return last;
        }
    }
}
