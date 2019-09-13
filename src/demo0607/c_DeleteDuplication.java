package demo0607;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class c_DeleteDuplication {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        System.out.println(deleteDuplication(head).val);
    }
    public static ListNode deleteDuplication(ListNode head){
        ListNode first=new ListNode(-1);
        first.next=head;
        ListNode preNode=first;//当前节点的上一节点
        ListNode curNode=head;//当前节点
        while(curNode!=null&&curNode.next!=null){
            if(curNode.val==curNode.next.val){
                int val=curNode.val;
                while(curNode!=null&&curNode.val==val){
                    curNode=curNode.next;
                    preNode.next=curNode;
                }
            }else {
                preNode=curNode;
                curNode=curNode.next;
            }
        }
        return first.next;
    }
}
