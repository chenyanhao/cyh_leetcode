package p001_p100.p083删除排序链表中的重复元素;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 可能会删除头结点，所以这里设置一个哑结点
        ListNode headfirst = new ListNode(-1);
        headfirst.next = head;

        ListNode a = headfirst, b  = head;
        while (b != null && b.next != null) {
            if (a.next.val == b.next.val) {
                while (b.next != null && b.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b.next = null;
                b = a.next;
            } else {
                a = a.next;
                b = b.next;
            }
        }

        return headfirst.next;
    }
}