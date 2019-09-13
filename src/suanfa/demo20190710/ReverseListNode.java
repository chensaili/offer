package suanfa.demo20190710;

import java.util.Stack;

/**
 * 自己敲一遍
 */
public class ReverseListNode {
    public static void main(String[] args) {

    }
    public static ListNode reverse(ListNode head,int num){
        if(num<2){
            return head;
        }
        Stack<ListNode> stack=new Stack<>();
        ListNode cur=head;
        ListNode newHead=head;
        ListNode pre=null;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            stack.push(cur);
            //如果栈的大小等于num
            if(stack.size()==num){
                //执行出栈操作，将出栈的节点链接，返回最后的节点
                //这个返回的节点就相当于是下一次入栈出栈操作的第一个节点的上一个节点
               pre=resign(stack,pre,next);
               newHead=newHead==head?cur:newHead;
            }
            cur=next;
        }
        return newHead;
    }
    public static ListNode resign(Stack<ListNode> stack,ListNode left,ListNode right) {
        ListNode cur = stack.pop();
        if(left!=null){
            left.next=cur;
        }
        ListNode next=null;
        while(!stack.isEmpty()){
            next=stack.pop();
            cur.next=next;
            cur=cur.next;
        }
        cur.next=right;
        return cur;
    }
}
