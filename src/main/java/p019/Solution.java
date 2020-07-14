package p019;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.List;

/**
 * 注意，可能把头节点删掉，例如 [1, 2]，删掉倒数第二个。所以需要置一个空节点，其 next 指向 head
 * 过程中注意防止各种空指针，例如 right.next 为空等。
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy, right = dummy;
        for (int i = 0; i < n + 1; ++i) {
            right = right.next;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}