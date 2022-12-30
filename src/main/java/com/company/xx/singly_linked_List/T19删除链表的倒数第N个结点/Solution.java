package com.company.xx.singly_linked_List.T19删除链表的倒数第N个结点;

import com.company.xx.剑指offer.ListNode;
import com.company.xx.剑指offer.ListNodeUtil;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode myHead = new ListNode(Integer.MAX_VALUE, head);
        ListNode fast = myHead, slow = myHead, pre = myHead;
        while (fast != null && n != 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) { // 不存在第n个节点
            return head;
        }
        while (fast != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        pre.next = slow.next;
        return myHead.next;
    }

    public static void main(String[] args) {
        int[] nodes = {1};
        ListNode head = ListNodeUtil.getLinkList(nodes);
        new Solution().removeNthFromEnd(head, 1);
    }
}
