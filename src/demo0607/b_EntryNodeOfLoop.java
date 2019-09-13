package demo0607;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class b_EntryNodeOfLoop {
    public static void main(String[] args) {
        ListNode pHead=new ListNode(0);
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        pHead.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n2;
        System.out.println(findEntryNode(pHead).val);
    }
    public static ListNode findEntryNode(ListNode pHead){
        if(pHead==null||pHead.next==null){
            return null;
        }
        ListNode p1=pHead;
        ListNode p2=pHead;
        //注意判断条件，我一开始想到的条件是p1!=p2
        while(p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                p2=pHead;
                while(p1!=p2){
                    p1=p1.next;
                    p2=p2.next;
                }
                if(p1==p2){
                    return p1;
                }
            }
        }
        return null;
    }
}
