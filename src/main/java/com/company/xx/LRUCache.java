package com.company.xx;

import java.util.Map;
import java.util.HashMap;

class LRUCache {
    public int size;
    public int capacity;
    public Node myHead;
    public Node myTail;
    public Map<Integer, Node> map;

    class Node {
        public int value;
        public int key;
        public Node pre;
        public Node next;
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        myHead = new Node();
        myTail = new Node();
        myHead.next = myTail;
        myTail.pre = myHead;
    }

    public void delete(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        map.remove(node.key);
    }

    public void addFirst(Node node) {
        Node next = this.myHead.next;
        this.myHead.next = node;
        node.pre = this.myHead;
        node.next = next;
        next.pre = node;
        map.put(node.key, node);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        delete(node);
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            delete(node);
            node.value = value;
            addFirst(node);
        } else {
            if (this.size == this.capacity) {
                delete(myTail.pre);
            }
            node = new Node();
            node.key = key;
            node.value = value;
            addFirst(node);
            this.size++;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
