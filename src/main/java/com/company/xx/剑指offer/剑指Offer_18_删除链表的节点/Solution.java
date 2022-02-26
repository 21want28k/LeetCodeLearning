package com.company.xx.剑指offer.剑指Offer_18_删除链表的节点;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode pre = headNode;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] values = {4, 5, 1, 9};
        s.deleteNode(ListNodeUtil.getLinkList(values), 5);
    }
}
