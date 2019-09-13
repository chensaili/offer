package suanfa.demo20190709;

import java.util.Stack;

/**
 * 复习：判断一个链表是否为回文结构
 */
public class IsPalindrome {
    public static void main(String[] args) {

    }
    //将右半部分的链表反转，再进行判断
    public static boolean isPalindrome1(ListNode head){
        if(head==null||head.next==null){
            return true;
        }
        //1.寻找中间节点
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;//p1最后所在位置为中间节点
            p2=p2.next.next;
        }
        //将p2设为右边链表的第一个节点
        p2=p1.next;
        //2.开始将右边链表反转
        ListNode p3=null;
        while(p2!=null){
            p3=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }
        //用p3记住原节点最后的位置
        //执行完上面的while循环后，p1位于原链表的最后一个节点的位置，这里用p3保留最后一个节点
        p3=p1;
        p2=head;
        boolean res=true;
        //3.开始判断是否为回文结构
        while (p1!=null&&p2!=null){
            if(p1.value!=p2.value){
                res=false;
                break;
            }
            p1=p1.next;//从右到中
            p2=p2.next;//从左到中
        }
        //4.恢复原链表，由前面分析可知，p3此时是位于原链表的最后的位置
        //p1和p2此时为空，可以作为恢复链表的辅助节点
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
    //使用额外的栈
    public static boolean isPalindrome2(ListNode head){
        if(head==null||head.next==null){
            return true;
        }
        Stack<ListNode>stack=new Stack<>();
        ListNode cur=head;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (head!=null){
            if(head.value!=stack.pop().value){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}
