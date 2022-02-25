package com.company.xx.剑指offer.剑指Offer_22_链表中倒数第k个节点;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k > 1) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        ListNode head = ListNodeUtil.getLinkList(list);
        Solution s = new Solution();
        s.getKthFromEnd(head, 2);
    }
}
