package p001_p100.p023合并K个升序链表;

import java.util.PriorityQueue;

/**
 *
 * 维护当前每个链表没有被合并的元素的最前面一个，每次取这些元素里面选取 val 最小的
 *
 * 时间复杂度：O(NlogK)。共需要合并 K 个链表，lists 中所有链表总节点的个数为 N。
 * 空间复杂度：O(logK)。优先队列的空间开销。
 *
 */
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val < o2.val) {
                return -1;
            } else if (o1.val > o2.val) {
                return 1;
            } else {
                return 0;
            }
        });
        for (ListNode l : lists) {
            if (l == null) {
                continue;
            }
            queue.add(l);
        }

        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        while (! queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) {
                queue.add(curr.next);
            }
        }

        return pre.next;
    }

}