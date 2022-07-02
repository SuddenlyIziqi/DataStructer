package Leetcode;

import java.util.HashMap;

/**
 * 146. LRU 缓存
 * 难度
 * 中等

 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class LeetCode146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        //"put","put","get","put","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

}
class LRUCache{
    //双向链表节点组成双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private int size;
    private int capacity;
    private DLinkedNode dummyHead;
    private DLinkedNode dummyTail;
    //HashMap实现快速检索get和修改put
    private HashMap<Integer, DLinkedNode> hashMap ;

    public LRUCache(int capacity){
        //初始化 懒加载
        this.size = 0;
        this.capacity =capacity;
        this.hashMap = new HashMap<Integer, DLinkedNode>();
        this.dummyHead = new DLinkedNode();
        this.dummyTail = new DLinkedNode();
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;

    }
    public int get(int key){
        DLinkedNode node = hashMap.get(key);
        if(node ==null){
            return -1;
        }else {
            moveToHead(node);
            return node.value;
        }
    }
    public void put(int key, int value){
        DLinkedNode node = hashMap.get(key);
        if(node ==null){
            DLinkedNode newNode = new DLinkedNode(key,value);
            addToHead(newNode);
            hashMap.put(key,newNode);
        }else {
            node.value=value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node){
        node.next= dummyHead.next;
        node.prev = dummyHead;
        //下面两行代码写错导致程序执行异常
        dummyHead.next.prev =node;
        dummyHead.next =node;

        size++;
        if(size>capacity){
            DLinkedNode oldTail = removeTail();
            hashMap.remove(oldTail.key);
        }
    }
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    private DLinkedNode removeTail(){
        DLinkedNode tail = dummyTail.prev;
        removeNode(tail);
        return tail;
    }
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
}
