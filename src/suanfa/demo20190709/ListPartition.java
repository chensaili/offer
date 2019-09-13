package suanfa.demo20190709;

import java.util.ArrayList;

public class ListPartition {
    public static void main(String[] args) {
        ListNode head=new ListNode(2);
        ListNode node1 =new ListNode(1);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(0);
        ListNode node4=new ListNode(6);
        ListNode node5=new ListNode(5);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode res=partition(head,2);
        System.out.println(res.value+" "+res.next.value+" "+res.next.next.value+" "
                +res.next.next.next.value+" "+res.next.next.next.next.value
                +" "+res.next.next.next.next.next.value);
    }
    public static ListNode partition(ListNode head,int num){
        if(head==null){
            return head;
        }
        ListNode cur=head;
        int i=0;
        //得到链表的长度
        while(cur!=null){
            i++;
            cur=cur.next;
        }
        //创建一个和链表一样大小的数组
        ListNode[] nodeArr=new ListNode[i];
        i=0;
        cur=head;
        //将链表的节点放入数组中
        for(i=0;i!=nodeArr.length;i++){
            nodeArr[i]=cur;
            cur=cur.next;
        }
        arrPartition(nodeArr,num);
        for(i=1;i!=nodeArr.length;i++){
            nodeArr[i-1].next=nodeArr[i];
        }
        nodeArr[i-1].next=null;
        return nodeArr[0];
    }
    //创建一个方法，将数组按某值分为左边小，中间相等，右边大的形式
    public static void arrPartition(ListNode[]nodeArr,int num){
        int small=-1;
        int big=nodeArr.length;
        int index=0;
        while(index!=big){
            if(nodeArr[index].value<num){
                swap(nodeArr,++small,index++);
            }else if(nodeArr[index].value==num){
                index++;
            }else {
                swap(nodeArr,--big,index);
            }
        }
    }
    public static void swap(ListNode[]nodeArr,int a,int b){
        ListNode temp=nodeArr[a];
        nodeArr[a]=nodeArr[b];
        nodeArr[b]=temp;
    }
}
