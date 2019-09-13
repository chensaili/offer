package demo0520fuxi;
/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 */
public class e_Merge {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(3);
        ListNode n3=new ListNode(7);
        ListNode n4=new ListNode(8);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        ListNode N1=new ListNode(1);
        ListNode N2=new ListNode(2);
        ListNode N3=new ListNode(5);
        ListNode N4=new ListNode(9);
        N1.next=N2;
        N2.next=N3;
        N3.next=N4;
        ListNode n=merge(n1,N1);
        System.out.println(n.val+" "+n.next.val+" "+n.next.next.val+" "+n.next.next.next.val);
    }
    public static ListNode merge(ListNode n1,ListNode n2){
        if(n1==null){
            return n2;
        }
        if(n2==null){
            return n1;
        }
        ListNode mergeHead;
        if(n1.val<=n2.val){
            mergeHead=n1;
            mergeHead.next=merge(n1.next,n2);
        }else {
            mergeHead=n2;
            mergeHead.next=merge(n1,n2.next);
        }
        return mergeHead;
    }
}
