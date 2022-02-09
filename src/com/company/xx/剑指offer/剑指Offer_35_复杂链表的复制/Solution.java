package com.company.xx.剑指offer.剑指Offer_35_复杂链表的复制;

import com.company.xx.剑指offer.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Integer, Node> map = getMap(head);
        Node newHead = new Node(0);
        Node oldCur = head;
        Node newCur = newHead;
        while (oldCur != null) {
            Node newNode = new Node(oldCur.val);
            newNode.random = oldCur.random == null ? null : map.get(oldCur.random);
            newNode.next = oldCur.next;
            newCur.next = newNode;
            newCur = newCur.next;
            oldCur = oldCur.next;
        }
        return newHead.next;
    }

    public Map<Integer, Node> getMap(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            map.put(index++, head);
            head = head.next;
        }
        return map;
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = getMap2(head);
        Node cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * map: get new node by old node
     *
     * @param cur pointer to traverse
     * @return map
     */
    public Map<Node, Node> getMap2(Node cur) {
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        return map;
    }

    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // add one node between two nodes in list
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        // reset cur
        cur = head;
        // build the random value of newNode
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node newHead = head.next;
        Node newPointer = newHead; // new node
        Node oldPointer = head; // old node
        // split the two list by the next value of node. The old list should be recover.
        while (newPointer != null) {
            oldPointer.next = oldPointer.next.next;
            if (newPointer.next != null) {
                newPointer.next = newPointer.next.next;
            }
            oldPointer = oldPointer.next;
            newPointer = newPointer.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.random = null;
    }
}
