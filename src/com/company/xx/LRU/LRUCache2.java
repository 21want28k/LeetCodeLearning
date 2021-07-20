package com.company.xx.LRU;

import java.util.HashMap;

public class LRUCache2 {

    private static class Node {
        int key, value;
        Node pre, next;

        public Node() {
        }

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

    public LRUCache2(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        // 带头结点的双链表
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    private void insertHead(Node node) {
        // 多一步不需要考虑到断链问题
        Node next = head.next;
        node.next = next;
        node.pre = head;
        head.next = node;
        next.pre = node;
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
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
        if (target == null) {
            return -1;
        }

        removeToHead(target);
        return target.value;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value, null, null);
        Node oldNode = this.map.get(key);
        // 如果存在
        if (oldNode != null) {
            oldNode.value = value;
            removeToHead(oldNode);
            return;
        }
        // 如果不存在
        // 满了，去尾部插入头部
        if (this.size >= capacity) {
            this.map.remove(key);
            // 因为有尾部虚拟结点，所以实际上是删除tail之前的
            removeNode(tail.pre);
            size--;
        }
        insertHead(newNode);
        size++;
        this.map.put(key, newNode);
    }

    /*
    ["LRUCache","put","put","put","get","put","put","get","put","put","get","put","get","get","get","put","put","get","put","get"]
[[10],[7,28],[7,1],[8,15],[6],[10,27],[8,10],[8],[6,29],[1,9],[6],[10,7],[1],[2],[13],[8,30],[1,5],[1],[13,2],[12]]
     */

    public static void main(String[] args) {
        LRUCache2 lRUCache = new LRUCache2(10);
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
