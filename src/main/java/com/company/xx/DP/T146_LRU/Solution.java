package com.company.xx.DP.T146_LRU;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int capacity;
    Node<Integer> myHead;
    Node<Integer> myTail;
    Map<Integer, Node<Integer>> map = new HashMap<>();

    class Node<T> {
        public Node<T> pre;
        public Node<T> next;
        public T key;
        public T value;

        public Node() {
        }

        public Node(T value, T key) {
            this.value = value;
            this.key = key;
        }
    }

    public Solution(int capacity) {
        this.capacity = capacity;
        this.myHead = new Node<>();
        this.myTail = new Node<>();
        myHead.next = myTail;
        myTail.pre = myHead;
    }

    public void delete(Node<Integer> node, int key) {
        Node<Integer> pre = node.pre;
        Node<Integer> next = node.next;
        pre.next = next;
        next.pre = pre;
        map.remove(key);
    }

    public void addFirst(Node<Integer> node, int key) {
        Node<Integer> next = myHead.next;
        this.myHead.next = node;
        node.next = next;
        node.pre = myHead;
        next.pre = node;
        map.put(key, node);
    }

    public int get(int key) {
        Node<Integer> node = map.get(key);
        if (node == null) {
            return -1;
        }
        delete(node, key);
        addFirst(node, key);
        return node.value;
    }

    public void put(int key, int value) {

        Node<Integer> node = map.get(key);
        if (node == null) {
            node = new Node<>(value, key);
            if (map.size() >= capacity) {
                delete(myTail.pre, myTail.pre.key);
            }
        } else {
            node.value = value;
            delete(node, key);
        }
        addFirst(node, key);
    }
}
