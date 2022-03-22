package p101_200.p146LRU缓存;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    private int size;
    private int capacity;

    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // 使用伪头和伪尾节点，方便删除头尾结点时写代码
        head = new DLinkedNode();
        tail = new DLinkedNode();
        // 头尾相连，方便快速由头到尾、由尾到头
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) { // key不存在
            return -1;
        }

        // 将node移到头部
        move2Head(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            move2Head(node);
            return;
        }

        DLinkedNode newNode = new DLinkedNode(key, value);
        cache.put(key, newNode);
        add2Head(node);
        ++size;

        if (size > capacity) {
            DLinkedNode tail = removeTail();
            cache.remove(tail.key);
            --size;
        }
    }

    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev, next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void move2Head(DLinkedNode node) {
        removeNode(node);
        add2Head(node);
    }

    private void add2Head(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */