package demo0604;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 两个无环链表，如果他们相交，那么只能形成Y或者V型
 */
public class b_FindFirstCommonNode {
    public static void main(String[] args) {

    }
    public static ListNode findFirstCommonNode(ListNode n1,ListNode n2){
        if(n1==null||n2==null){
            return null;
        }
        int n=0;//用来记录两个链表长度的长度差
        //判断两个链表的最后一位是否是同一个，若不是，则肯定不是不相交
        ListNode cur1=n1;
        ListNode cur2=n2;
        while(cur1.next!=null){
            n++;
            cur1=cur1.next;
        }
        while(cur2.next!=null){
            n--;
            cur2=cur2.next;
        }
        if(cur1!=cur2){
            return null;
        }
        //n大于0表示链表1比链表2长，反之，链表2比链表1长
        //cur1设置为长链表的头节点
        cur1=n>0?n1:n2;
        cur2=cur1==n1?n2:n1;
        n = Math.abs(n);
        //让长链表的指针先走n步
        while(n!=0) {
            n--;
            cur1=cur1.next;
        }
        //然后让长链表和短链表的指针一起走
        while(cur1!=cur2) {
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }
}
