package com.company.xx.singly_linked_List.T237_Delete_Node_in_a_Linked_List;

import com.company.xx.剑指offer.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
