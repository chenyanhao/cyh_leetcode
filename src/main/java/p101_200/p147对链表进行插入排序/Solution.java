package p101_200.p147对链表进行插入排序;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        // 构建头节点的前驱结点，便于链表插入
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val < cur.next.val) {
                cur = cur.next;
                continue;
            }

            // 1）找到不符合顺序的元素，记为 toBeInserted，并重新链接 cur 和 toBeInserted 指针关系
            ListNode toBeInserted = cur.next;
            cur.next = cur.next.next;
            toBeInserted.next = null;

            // 2）从头开始寻找插入位置，search.next 即为合适的插入位置
            ListNode search = dummy;
            while (search.next.val < toBeInserted.val) {
                search = search.next;
            }
            toBeInserted.next = search.next;
            search.next = toBeInserted;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode newHead = new Solution().insertionSortList(n1);
        printList(newHead);
    }

    public static void printList(ListNode src) {
        List<Integer> res = new ArrayList<>();
        while (src != null) {
            res.add(src.val);
            src = src.next;
        }
        System.out.println(res);
    }
}