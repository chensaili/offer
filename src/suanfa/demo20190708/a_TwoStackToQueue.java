package suanfa.demo20190708;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class a_TwoStackToQueue {
    public static void main(String[] args) {
        TwoStackQueue twoStackQueue=new TwoStackQueue();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);
        twoStackQueue.add(4);
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
    }
    public static class TwoStackQueue{
        private  Stack<Integer>stackPop;
        private  Stack<Integer>stackPush;
        public TwoStackQueue(){
            stackPop=new Stack<>();
            stackPush=new Stack<>();
        }
        //将数据存入push栈
        public  void add(int num){
            stackPush.push(num);
        }
        //从pop栈中取出数据
        //两个原则：pop栈中有数据时，不能往pop栈里存放数据；push栈里的数据要一次性存入pop栈
        public  int poll(){
            if(stackPop.isEmpty()&&stackPush.isEmpty()){
                throw new RuntimeException("Queue is empty!");
            }else if(stackPop.isEmpty()){//原则1
                while(!stackPush.isEmpty()){//原则2
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek(){
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}
