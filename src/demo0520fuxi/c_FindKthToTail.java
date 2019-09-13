package demo0520fuxi;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 注意判空
 */
public class c_FindKthToTail {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode n1=new ListNode(2);
        ListNode n2=new ListNode(3);
        ListNode n3=new ListNode(4);
        ListNode n4=new ListNode(5);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        int k=3;
        ListNode res=findKthToTail(head,k);
        System.out.println(res.val);
    }
    public static ListNode findKthToTail(ListNode head,int k){
        if(head==null||k==0){
            return null;
        }
        ListNode p1=head;
        ListNode p2=head;
        for(int i=1;i<k;i++){
            if(p1==null){
                return null;
            }
            //让pre指针先走k-1步到达第k个节点,所以i应该从1开始，不能从0开始
            p1=p1.next;
        }
        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }
}
