package p001_p100.p023合并K个升序链表;

/**
 * 时间复杂度：
 * 假设共需要合并 K 个链表，lists 中所有链表总节点的个数为 N。
 * 平均每条链表有 N/K 个节点，因此合并两条链表的时间复杂度是 O(N/K)。
 * K 条链表每两两合并成1条链表，因此每条链表都会被合并 logK 次，因此 K 条链表会被合并 K*logK 次。
 * 因此总共的时间复杂度是 O(K*logK * N/K) = O(NlogK)。
 *
 * 空间复杂度：O(logK)。递归所需的空间开销。
 *
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return dfs(lists, 0, lists.length-1);
    }

    /**
     * 模仿归并排序
     */
    private ListNode dfs(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode l1 = dfs(lists, start, mid);
        ListNode l2 = dfs(lists, mid + 1, end);
        return mergeTwo(l1, l2);
    }

    /**
     * 模仿归并排序的写法
     */
    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode merged = pre;

        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                merged.next = new ListNode(p1.val);
                p1 = p1.next;
                merged = merged.next;
            } else {
                merged.next = new ListNode(p2.val);
                p2 = p2.next;
                merged = merged.next;
            }
        }

        while (p1 != null) {
            merged.next = new ListNode(p1.val);
            p1 = p1.next;
            merged = merged.next;
        }

        while (p2 != null) {
            merged.next = new ListNode(p2.val);
            p2 = p2.next;
            merged = merged.next;
        }

        return pre.next;
    }
}