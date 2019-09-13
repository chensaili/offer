package demo0307;

/**
 * 输入一个链表，反转链表后，输出新链表的表头
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
       System.out.println(revserList(n1).val);
    }
    public static ListNode revserList(ListNode head){
        //判断输入的链表是否为空或者是只有一个节点
        if(head==null||head.next==null) {
            return head;
        }
        //创建三个指针
        ListNode pre=null;
        ListNode last=null;
        while(head!=null){
            //保存下一个节点
            last=head.next;
            //将当前指针指向上一个节点pre
            head.next=pre;
            pre=head;
            head=last;
        }
        return pre;
    }
}
