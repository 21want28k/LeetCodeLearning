package com.company.xx.singly_linked_List.T206反转链表;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head, next, pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(head, null);
    }

    /**
     * 从前向后去逆转
     */
    public ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(next, cur);
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode newNode = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }


    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5};
        ListNode lis = ListNodeUtil.getLinkList(nodes);
        new Solution().reverseList(lis);
    }
}
