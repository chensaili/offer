package demo0307;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        ListNode k=findKthToTail(n1,5);
        System.out.println(k.val);
    }
    public static ListNode findKthToTail(ListNode head,int k){
        if(head==null||k==0) {
            return null;
        }
        ListNode pre=head;
        ListNode last=head;
        int i=0;
        for(i=0;last!=null;i++){
            if(i>=k){
                pre=pre.next;
            }
            last=last.next;
        }
        return i<k?null:pre;
    }
}
