package demo0308;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class GetMin {
    Stack<Integer>data_stack=new Stack<>();
    Stack<Integer>min_stack=new Stack<>();
    public void push(int node){
        if(min_stack.isEmpty()||min_stack.peek()>node){
            min_stack.push(node);
        }else {
            min_stack.push(min_stack.peek());
        }
        data_stack.push(node);
    }
    public void pop(){
        if(data_stack.isEmpty()||min_stack.isEmpty()){
            return ;
        }
        data_stack.pop();
        min_stack.pop();
    }
    public int top(){
        if(!data_stack.isEmpty()){
            return data_stack.peek();
        }
        return 0;
    }
    public int min(){
        if(!min_stack.isEmpty()){
            return min_stack.peek();
        }
        return 0;
    }
}
