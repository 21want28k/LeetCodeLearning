package com.company.xx.other.T432全_O1_的数据结构;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

    Node head;
    Node tail;
    Map<String, Node> map = new HashMap<>();

    public AllOne() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void clear(Node node) {
        if (node.set.size() == 0) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    public void inc(String key) {
        Node pos = map.get(key);
        if (pos == null) {
            Node n;
            // head和tail之间有节点且是1
            if (head.next.count == 1) {
                n = head.next;
                n.set.add(key);
            } else {
                // head之后有其他节点并且不是1（包括光秃秃的只有tail）就需要进行插入
                n = new Node();
                n.count = 1;
                n.set = new HashSet<>();
                n.set.add(key);

                Node next = head.next;

                head.next = n;
                next.pre = n;
                n.pre = head;
                n.next = next;
            }
            map.put(key, n);

        } else {
            // position of new node
            Node node;
            pos.set.remove(key);
            if (pos.next.count == pos.count + 1) {
                pos.next.set.add(key);
                node = pos.next;
            } else {
                node = new Node();
                node.count = pos.count + 1;
                node.set = new HashSet<>();
                node.set.add(key);

                // insert
                node.next = pos.next;
                pos.next = node;
                node.next.pre = node;
                node.pre = pos;
            }
            clear(pos);
            map.put(key,node);
        }
    }

    public void dec(String key) {
        Node pos = map.get(key);
        if (pos == null) {
            return;
        }
        if (pos.count == 1) {
            pos.set.remove(key);
            map.remove(key);
        } else {
            Node node;
            map.remove(key);
            if (pos.pre.count == pos.count - 1) {
                pos.set.remove(key);
                pos.pre.set.add(key);
                node = pos.pre;
            } else {
                node = new Node();
                node.count = pos.count - 1;
                node.set = new HashSet<>();
                node.set.add(key);

                pos.pre.next = node;
                pos.next.pre = node;
                node.pre = pos.pre;
                node.next = pos.next;
            }
            map.put(key, node);
        }
        clear(pos);
    }

    public String getMaxKey() {
        if (head.next == tail) {
            return "";
        } else {
            return tail.pre.set.iterator().next();
        }
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        } else {
            return head.next.set.iterator().next();
        }
    }

    class Node {
        Node pre;
        Node next;
        Set<String> set;
        int count;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("world");
        allOne.inc("hello");
        allOne.dec("world");
        allOne.inc("hello");
        allOne.inc("leet");
        allOne.getMaxKey(); // 返回 "hello"
        allOne.dec("hello");
        allOne.dec("hello");
        allOne.dec("hello");
        allOne.getMaxKey(); // 返回 "hello"
    }
}
