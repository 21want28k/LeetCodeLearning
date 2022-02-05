package com.company.xx.剑指offer.剑指Offer_24_反转链表;

import com.company.xx.剑指offer.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode p;
        while (cur != null) {
            p = cur.next;
            cur.next = pre;
            pre = cur;
            cur = p;
        }
        return pre;
    }

    /**
     *
     * 解法地址：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/jian-zhi-offer-24-fan-zhuan-lian-biao-die-dai-di-2/
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return recursion(head, null);
    }


    public ListNode recursion(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode head = recursion(cur.next, cur);
        cur.next = pre;
        return head;
    }
}
