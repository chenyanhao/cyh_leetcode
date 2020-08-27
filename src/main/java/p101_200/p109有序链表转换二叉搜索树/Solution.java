package p101_200.p109有序链表转换二叉搜索树;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // 递归终止条件
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 通过快慢指针找到中间节点
        ListNode slow = head, pre = null, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 断开链表
        pre.next = null; // 断开左半部分
        ListNode next = slow.next; // 对于右半部分，先保存 next 节点，然后再置空以断开链表
        slow.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(next);

        return root;
    }
}