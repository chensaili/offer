package demo0520fuxi;

/**
 * 反转链表
 */
public class d_ReverseList {
    public static ListNode reverse(ListNode head){
        if(head==null||head.next==null) {
            return head;
        }
        ListNode pre=null;
        ListNode last=null;
        while (head!=null){
            last=head.next;
            head.next=pre;
            pre=head;
            head=last;
        }
        return pre;
    }
}
