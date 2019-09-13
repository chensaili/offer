package demo0526;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head
 * 要求不使用哈希表
 */
public class c_CloneList {
    public static RandomList cloneRandomList(RandomList head){
        if(head==null){
            return null;
        }
        //1.将复制的节点插入原链表中
        RandomList cur=head;//当前节点
        RandomList next=null;
        while(cur!=null){
            next=cur.next;
            //new RandomList(cur.value)复制节点，并把这个节点放在被复制对象的后面
            cur.next=new RandomList(cur.value);
            cur.next.next=next;
            cur=next;
        }
        //2.复制随机节点
        cur=head;
        RandomList curCopy=null;
        while(cur!=null){
            next=cur.next.next;
            curCopy=cur.next;
            curCopy.rand=cur.rand!=null?cur.rand.next:null;
            cur=next;
        }
        //3.将合在一起的链表分离为原始链表和复制链表
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
