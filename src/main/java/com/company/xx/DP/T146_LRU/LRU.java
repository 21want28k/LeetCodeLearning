package com.company.xx.DP.T146_LRU;

public class LRU<E> {
    private static class Node<E> {
        E key, value;
        Node<E> next;

        public Node(E key, E value, Node<E> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int capability;
    private int size;
    private Node<E> head;

    public LRU() {
    }

    public LRU(int capability) {
        this.capability = capability;
    }


    private void insertHead(Node<E> current) {
        current.next = head;
        head = current;
    }

    private void removeNode(Node<E> pre, Node<E> current) {
        pre.next = current.next;
    }

    private void removeNodeToHead(Node<E> pre, Node<E> current) {
        removeNode(pre, current);
        insertHead(current);
    }

    public void printAll() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.value + ",");
            current = current.next;
        }
        System.out.println();
    }

    public E get(E key) {
        // 刚好是头部不需要动
        if (key.equals(head.key)) {
            return head.value;
        }

        Node<E> current = head, pre = head;
        while (current != null && !current.key.equals(key)) {
            pre = current;
            current = current.next;
        }
        if (current == null) {
            return null;
        } else {
            // 找到了返回值，并且去尾插头
            removeNodeToHead(pre, current);
            return current.value;
        }
    }

    public void set(E key, E value) {
        Node<E> node = new Node<>(key, value, null);
        // 如果是空的话
        if (size == 0) {
            head = node;
            size++;
            return;
        }

        // 如果刚好是头结点
        if (node.key.equals(head.key)) {
            return;
        }
        Node<E> current = head, pre = null, q = null;
        while (current != null && current.key != node.key) {
            q = pre;
            pre = current;
            current = current.next;
        }

        // 如果是满了
        if (size == capability) {
            // 不在链表里面，需要去尾插头
            if (current == null) {
                assert q != null;
                removeNode(q, pre);
                insertHead(node);
                // 在链表里面，删除插入头部
            } else {
                removeNodeToHead(pre, current);
            }
            // 如果不满的话,也分查找到和未查找到
        } else {
            // 不在链表里面，直接插入尾部
            if (current == null) {
                // 此时pre指向尾部
                pre.next = node;
                size++;

                // 在链表里面，删除插入头部
            } else {
                removeNodeToHead(pre, current);
            }
        }
    }

    /*
1,
1,
3,1,
3,1,
5,3,1,
3
3,5,1,
     */
    public static void main(String[] args) {
        LRU<Integer> lru = new LRU<>(3);
        lru.set(1, 1);
        lru.printAll();

        lru.set(3, 3);
        lru.printAll();

        lru.set(3, 3);
        lru.printAll();

        lru.set(4, 4);
        lru.printAll();

        lru.set(5, 5);
        lru.printAll();

        System.out.println(lru.get(3));
        lru.printAll();
    }
}