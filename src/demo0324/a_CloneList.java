package demo0324;

import demo0309.RandomList;

/**
 * 复制含有随机指针节点的链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * 要求不使用哈希表
 */
public class a_CloneList {
    public RandomList cloneList(RandomList head){
        if(head==null){
            return null;
        }
        //1.将复制的节点插入原链表中
        RandomList cur=head;
        RandomList next=null;
        while(cur.next!=null){
            next=cur.next;
            cur.next=new RandomList(cur.value);
            cur.next.next=next;
            cur=next;
        }
        //2.复制随机节点
        cur=head;
        RandomList curCopy=null;
        while (cur.rand!=null){
            next=cur.next.next;
            curCopy=cur.next;
            curCopy.rand=cur.rand!=null?cur.rand.next:null;
            cur=next;
        }
        //3.将两个链表分离
        RandomList res=head.next;
        cur=head;
        while(cur!=null){
            next=cur.next.next;
            curCopy=cur.next;
            cur.next=next;
            curCopy.next=next!=null?next.next:null;
            cur=next;
        }
        return res;
    }
}
