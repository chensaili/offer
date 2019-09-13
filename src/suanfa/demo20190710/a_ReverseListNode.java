package suanfa.demo20190710;

import java.util.Stack;

/**
 * 将单链表的每K个节点之间逆序
 */
public class a_ReverseListNode {
    public static void main(String[] args) {
        ListNode head=new ListNode(2);
        ListNode node1 =new ListNode(1);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(0);
        ListNode node4=new ListNode(6);
        ListNode node5=new ListNode(5);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode newhead=reverse1(head,3);
        System.out.println(newhead.value+" "+newhead.next.value+" "+newhead.next.next.value+" "
                +newhead.next.next.next.value+" "+newhead.next.next.next.next.value+" "+newhead.next.next.next.next.next.value);
    }
    public static ListNode reverse1(ListNode head,int num){
        if(num<2){
            return head;
        }
        Stack<ListNode>stack=new Stack<>();
        ListNode newHead=head;//表示逆序完成后整个链表的头节点，其实就是第一个长度链表的最后一个节点
        ListNode cur=head;
        ListNode pre=null;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            stack.push(cur);
            //如果栈的大小与num相同了，那么开始执行出栈，开始每一部分的逆序
            if(stack.size()==num){
                pre=resign1(stack,pre,next);//这个返回的pre用来指向下一个倒序后的链表的第一个节点
                newHead=newHead==head?cur:newHead;//看书第68页
            }
            cur=next;
        }
        return newHead;
    }
    //例:1-2-3-4-5-6-7，num=3，那么第一次逆序时，left为null，right为4
    public static ListNode resign1(Stack<ListNode> stack,ListNode left,ListNode right){
        ListNode cur=stack.pop();
        if(left!=null){
            left.next=cur;
        }
        ListNode next=null;
        while(!stack.isEmpty()){
            next=stack.pop();
            cur.next=next;
            cur=next;
        }
        cur.next=right;
        return cur;
    }
}
