package com.company.xx.剑指offer.剑指Offer_06_从尾到头打印链表;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    public int[] reversePrint(ListNode head) {
        int n = this.getLength(head);
        int[] result = new int[n];

        while (head != null) {
            result[--n] = head.val;
            head = head.next;
        }
        return result;
    }

    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] values = {1, 2, 3, 4};
        ListNode head = ListNodeUtil.getLinkList(values);
    }
}
