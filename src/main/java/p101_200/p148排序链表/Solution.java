package p101_200.p148排序链表;

/**
 * 要复杂度低，本题只能归并排序
 * 归并分为两种实现：自顶向下和自底向上
 *
 * 解法一：自顶向下
 */
class Solution {

    /**
     * 通过递归实现链表归并排序，有以下两个环节：
     *     cut： 找到当前链表中点，并从中点将链表断开；
     *         1) 使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
     *         2) 找到中点 slow 后，执行 slow.next = None 将链表切断。
     *         3) cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
     *     merge： 将两个排序链表合并，转化为一个排序链表。双指针法合并，同数组的归并排序 merge 阶段相同。
     *         1) left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部。
     *         2) 两指针交替前进，直至添加完两个链表。
     *
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode merge = new ListNode(0);
        ListNode res = merge;
        while (left != null && right != null) {
            if (left.val < right.val) {
                merge.next = left;
                left = left.next;
            } else {
                merge.next = right;
                right = right.next;
            }
            merge = merge.next;
        }

        merge.next = left != null ? left : right;

        return res.next;
    }
}