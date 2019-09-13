package demo0223;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 * 递归
 */
public class PrintListFromTailToHead {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        ArrayList<Integer>arrayList=printListFromTailToHead(n1);
        for(Integer in:arrayList){
            System.out.print(in+" ");
        }
    }
    //静态方法不能使用非静态变量，故下面一行需要加上static
    static ArrayList<Integer>arrayList=new ArrayList<Integer>();
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
