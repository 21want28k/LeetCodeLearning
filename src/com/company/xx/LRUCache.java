package com.company.xx;

import java.util.HashMap;
import java.util.Timer;

public class LRUCache {
    private static class Node {
        int key, value;
        Node pre, next;

        public Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    private int size;
    private int capacity;
    private Node head, tail;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    private void insertHead(Node node) {
        node.next = head;
        head.pre = node;
        head = node;
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        if (node == tail) {
            pre.next = null;
            tail = pre;
            return;
        }
        if (node == head) {
            next.pre = null;
            head = next;
            return;
        }
        pre.next = next;
        next.pre = pre;
    }

    private void insertTail(Node node) {
        tail.next = node;
        node.pre = tail;
        tail = node;
    }

    private void removeToHead(Node node) {
        removeNode(node);
        insertHead(node);
    }

    public int get(int key) {
        Node target = this.map.get(key);
        if (this.size == 0 || target == null) {
            return -1;
        }

        if (key == this.head.key) {
            return this.head.value;
        }

        removeToHead(target);
        return target.value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value, null, null);
        if (this.size == 0) {
            head = node;
            tail = node;
            size++;
            this.map.put(key, node);
            return;
        }

        Node node1 = this.map.get(key);
        if (node1 == head) {
            node1.value = value;
            this.map.put(key, node1);
            return;
        }
        if (node1 != null) {
            node1.value = value;
            removeToHead(node1);
            this.map.put(key, node1);
            return;
        }
        // 满了，去尾部插入头部
        if (this.size >= capacity) {
            if (this.size == 1) {
                this.map.remove(tail.key);
                head = node;
                tail = node;
                this.map.put(key, node);
                return;
            }
            this.map.remove(tail.key);
            removeNode(tail);
            insertHead(node);
            this.map.put(key, node);
        } else {
            insertHead(node);
            size++;
            this.map.put(key, node);
        }
    }

    /*
    ["LRUCache","put","put","put","get","put","put","get","put","put","get","put","get","get","get","put","put","get","put","get"]
[[10],[7,28],[7,1],[8,15],[6],[10,27],[8,10],[8],[6,29],[1,9],[6],[10,7],[1],[2],[13],[8,30],[1,5],[1],[13,2],[12]]
     */

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(10);
        lRUCache.put(7, 28);
        lRUCache.put(7, 1);
        lRUCache.put(8, 15);
        System.out.println(lRUCache.get(6));
        lRUCache.put(10, 27);
        lRUCache.put(8, 10);
        System.out.println(lRUCache.get(8));
        lRUCache.put(6, 29);
        lRUCache.put(1, 9);
        System.out.println(lRUCache.get(6));
        lRUCache.put(10, 7);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(13));
        lRUCache.put(8, 30);
        lRUCache.put(1, 5);
        System.out.println(lRUCache.get(1));
        lRUCache.put(13, 2);
        System.out.println(lRUCache.get(12));
    }
}