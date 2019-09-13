package demo0516fuxi;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 解题思路：使用递归
 */
public class c_PrintListFromTailHead {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        head.next=node2;
        node2.next=node3;
        node3.next=node4;
        print(head);
        for(Integer in: result){
            System.out.print(in+" ");
        }
    }
    static ArrayList<Integer>result=new ArrayList<>();
    public static ArrayList<Integer> print(ListNode node){
        if(node!=null){
            print(node.next);
            result.add(node.val);
        }
        return result;
    }
}
