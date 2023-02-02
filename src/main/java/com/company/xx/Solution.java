package com.company.xx;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

import java.io.BufferedReader;
import java.util.Arrays;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        // 计算长度
        while (node != null) {
            length++;
            node = node.next;
        }
        // 伪头节点
        ListNode dummyHead = new ListNode(0, head);
        // ListNode prev = dummyHead, curr = dummyHead.next; 很容易犯错的地方，会造成只有一轮排序的错误结果
        // subLength 表示每次需要排序的子链表的长度
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            // prev 用来将合并之后的链表链接起来。
            ListNode prev = dummyHead, curr = dummyHead.next;

            // cur永远指向待排序的链表的头。
            while (curr != null) {

                // 先选subLength个长度作为h1
                ListNode head1 = curr;
                // 上面while循环已经说明h1是不可能为空了。但是有可能h1的长度就不够subLength
                // 需要一直将cur移动到h1的尾部，注意cur始终不能为空。尾部是实打实的尾部。
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 先记录下head2的头部，不然断开之后就找不到了
                ListNode head2 = curr.next;
                // h1和h2断开
                curr.next = null;
                // cur指向h2
                curr = head2;
                // 注意h2可能是空的
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // next记录下，下一个待排序的链表，注意，cur这个时候也指向下一个待排序的链表，但是下一个链表可能是不存在的。存在的时候才需要去断开。
                ListNode next = null; // 错误next = cur.next; 因为cur可能是空
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                // 合并
                ListNode merged = merge(head1, head2);
                // 和已经排序好的链表链接起来。
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                // cur移动到下一个待排序的链表当中
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        int[] nodes = {4, 3, 2, 6, 5, 7, 1};
        new Solution().sortList(ListNodeUtil.getLinkList(nodes));
    }
}
