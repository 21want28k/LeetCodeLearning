package com.company.xx.singly_linked_List.T24两两交换链表中的节点;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode myNode = new ListNode(Integer.MAX_VALUE, head);
        ListNode cur = myNode.next;
        ListNode pre = myNode;
        while (cur != null) {
            ListNode next = cur.next;
            // 防止单数 比如[1,2,3]
            if (next == null) {
                break;
            }
            // 节点操作
            pre.next = next;
            cur.next = next.next;
            next.next = cur;

            // 更新值
            pre = cur;
            cur = cur.next;
        }
        return myNode.next;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4};
        new Solution().swapPairs(ListNodeUtil.getLinkList(nodes));
    }
}
