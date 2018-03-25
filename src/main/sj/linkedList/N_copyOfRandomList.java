package sj.linkedList;

import resources.RandomListNode;

import java.util.HashMap;

/**
 * Created by steven on 18-3-24 上午10:25
 * shijia0620@126.com
 *
 * 复杂链表的复制
 */
public class N_copyOfRandomList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode older = pHead;
        RandomListNode younger = newHead;
        //todo hashMap神来之笔，极大简化了
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        map.put(older,younger);
        while(older.next != null){
            younger.next = new RandomListNode(older.next.label);
            younger = younger.next;
            older = older.next;
            map.put(older,younger);
        }
        younger = newHead;
        older = pHead;
        while(younger != null && older!=null){
            younger.random = map.get(older.random);
            younger = younger.next;
            older = older.next;
        }
        return newHead;
    }
}
