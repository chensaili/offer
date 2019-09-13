package suanfa.demo20190708;

import java.util.Stack;

public class TwoStackToQueue {
    public static void main(String[] args) {

    }
    public class TwoStackToQueue1{
        Stack<Integer>stackPush=new Stack<>();
        Stack<Integer>stackPop=new Stack<>();

        public void push(Integer num){
            stackPush.push(num);

        }
        public int poll() throws Exception {
            if(stackPop.isEmpty()&&stackPush.isEmpty()){
                throw new RuntimeException("队列为空！");
            }else if(stackPop.isEmpty()){
                    while(!stackPush.isEmpty()){
                        stackPop.push(stackPush.pop());
                    }
            }
            return stackPop.pop();
        }
        public int peek() throws Exception {
            if(stackPop.isEmpty()&&stackPush.isEmpty()){
                throw new RuntimeException("队列为空！");
            }else if(stackPop.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}
