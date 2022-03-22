package p001_p100.p082删除排序链表中的重复元素2;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy, cur = head;
        while(cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}