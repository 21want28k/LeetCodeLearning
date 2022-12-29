package com.company.xx.singly_linked_List.T203移除链表元素;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(Integer.MAX_VALUE, head);
        ListNode cur = newHead.next;
        ListNode pre = newHead;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] list = {7, 7, 7, 7};
        ListNode listNode = ListNodeUtil.getLinkList(list);
        new Solution().removeElements(listNode, 7);
    }
}
