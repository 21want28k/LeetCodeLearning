package com.company.xx.singly_linked_List.T707设计链表;


class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}

public class MyLinkedList {
    int total = 0;
    ListNode myHead = new ListNode(Integer.MAX_VALUE); // 伪头节点
    ListNode tail = myHead;

    public MyLinkedList() {
    }

    public int get(int index) {
        if (index > total - 1) {
            return -1;
        }
        ListNode cur = myHead;
        while (index != -1) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val, myHead.next);
        myHead.next = node;
        if (total == 0) {
            tail = node;
        }
        total++;
    }

    public void addAtTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
        total++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == total) {
            addAtTail(val);
            return;
        }
        if (index > total) {
            return;
        }
        ListNode cur = myHead;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        ListNode node = new ListNode(val, cur.next);
        cur.next = node;
        total++;
    }

    public void deleteAtIndex(int index) {
        if (index > total - 1 || index < 0) {
            return;
        }
        ListNode cur = myHead;
        ListNode pre = null;
        while (index != -1) {
            pre = cur;
            cur = cur.next;
            index--;
        }
        pre.next = cur.next;
        if (tail == cur) { // 如果删的是尾节点要更新tail
            tail = pre;
        }
        total--;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
        linkedList.deleteAtIndex(1);
    }
}
