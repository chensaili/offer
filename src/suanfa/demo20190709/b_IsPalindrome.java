package suanfa.demo20190709;

import java.util.Stack;
/**
 * 判断一个链表是否为回文结构
 * 关键：(1)每次操作之后p1，p2，p3的位置位于链表的上面位置
 *      (2)用当时为null的p1,p2或者p3来辅助链表反转
 */
public class b_IsPalindrome {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node1 =new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(1);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println(isPalindrome1(head));
        System.out.println(isPalindrome2(head));
    }
    //不使用额外的栈，空间复杂度为O(1)
    public static boolean isPalindrome2(ListNode head){
        if(head==null||head.next==null){
            return true;
        }
        ListNode p1=head;
        ListNode p2=head;
        //1、寻找中间节点
        while (p2.next!=null&&p2.next.next!=null){
            p1=p1.next;//p1最后所在位置为中间节点
            p2=p2.next.next;//p2最后的所在位置是在链表的最后
        }
        p2=p1.next;//将p2设为右边链表的第一个节点
        p1.next=null;
        //2、创建p3，辅助右边链表反转
        ListNode p3=null;
        while(p2!=null){
            p3=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }
        p3=p1;//执行完上面的while循环后，p1位于原链表的最后一个节点的位置，这里用p3保留最后一个节点
        p2=head;//用p2保留原链表的第一个节点
        boolean res=true;
        //3、开始判断是否为回文结构
        while (p1!=null&&p2!=null){
            if(p1.value!=p2.value){
                res=false;
                break;
            }
            p1=p1.next;//从右到中
            p2=p2.next;//从左到中
        }
        //4、恢复链表
        p1=p3.next;
        p3.next=null;
        while(p1!=null){
            p2=p1.next;
            p1.next=p3;
            p3=p1;
            p1=p2;
        }
        return res;
    }
    //使用了额外的栈，空间复杂度为O(N)
    public static boolean isPalindrome1(ListNode head){
        Stack<ListNode>stack=new Stack<>();
        ListNode cur=head;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while(head!=null){
            if(head.value!=stack.pop().value){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}
