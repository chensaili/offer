package suanfa.demo3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 仅用队列实现栈
 */
public class e_Queue_To_Stack {
    public static void main(String[] args) {
        TwoQueueStack twoQueueStack=new TwoQueueStack();
        twoQueueStack.push(1);
        twoQueueStack.push(2);
        twoQueueStack.push(3);
        twoQueueStack.push(4);
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());
    }
    public static class TwoQueueStack{
        private Queue<Integer>queue;
        private Queue<Integer>help;
        public TwoQueueStack(){
            queue=new LinkedList<>();
            help=new LinkedList<>();
        }
        //往queuePush队列中添加数据
        public void push(int num){
            queue.add(num);
        }
        //往queuePop队列中取出数据
        public int pop(){
            if(queue.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            //将queue中前面的元素都取出放入help中，只剩下最后一元素
            while(queue.size()!=1){
                help.add(queue.poll());
            }
            int res=queue.poll();
            swap();
            return res;
        }
        public int peek(){
            if(queue.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            //将queue中前面的元素都取出放入help中，只剩下最后一元素
            while(queue.size()!=1){
                help.add(queue.poll());
            }
            int res=queue.poll();
            swap();
            return res;
        }
        //两个队列互换
        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }
    }
}
