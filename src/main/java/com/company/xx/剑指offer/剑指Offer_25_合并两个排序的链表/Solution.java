package com.company.xx.剑指offer.剑指Offer_25_合并两个排序的链表;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtil.getLinkList(new int[]{1, 2, 4});
        ListNode l2 = ListNodeUtil.getLinkList(new int[]{1, 3, 4});
        Solution s = new Solution();
        s.mergeTwoLists(l1, l2);
    }
}
