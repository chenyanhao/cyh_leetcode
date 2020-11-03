package p101_200.p148排序链表;

/**
 * 要复杂度低，本题只能归并排序
 * 归并分为两种实现：自顶向下和自底向上
 *
 * 解法二：自底向上
 *
 * 自底向上归并是非递归的，需要使用迭代的方式替换解法一中的 cut 环节，具体如下。
 *
 * 每一轮合并 merge 操作针对的单元都有固定长度 intv，
 *      - 第一轮合并时 intv = 1，即将整个链表切分为多个长度为 1 的单元，并按顺序两两排序合并，合并完成的已排序单元长度为 2。
 *      - 第二轮合并时 intv = 2，即将整个链表切分为多个长度为 2 的单元，并按顺序两两排序合并，合并完成的已排序单元长度为 4。
 *      - 以此类推，直到单元长度intv >= 链表长度，代表已经排序完成。
 *
 * 整体流程为，
 *     1) 统计链表长度 length，用于通过判断 intv < length 判定是否完成排序；
 *     2) 额外声明一个哑节点 dummy，作为头部后面接整个链表，用于：
 *         - intv *= 2 即切换到下一轮合并时，可通过 dummy.next 找到链表头部 h；
 *     3) 在每轮 intv 下的合并流程：
 *         - 根据 intv 找到合并单元 1 和单元 2 的头部 h1, h2。由于链表长度可能不是 2^n，需要考虑边界条件。
 *         - 合并长度为 c1, c2 的 h1, h2 链表
 *     4) 每轮合并完成后将单元长度 * 2，切换到下轮合并，即 intv *= 2。
 *
 */
class Solution2 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 统计链表长度
        int length = getListLen(head);
        int intv = 1;
        while (intv < length) {
            ListNode pre = dummy;
            ListNode h = dummy.next;

            // 该处 while 循环中为每轮 intv 下的合并流程
            while (h != null) {
                // 找到合并链表的 h1 和 h2 头节点，注意需要考虑边界条件: 在找 h2 过程中，如果链表剩余元素个数少于 intv，则无需合并环节，直接 break，执行下一轮合并
                int i = intv;
                ListNode h1 = h;
                for (; h != null && i > 0; --i) {
                    h = h.next;
                }

                // i>0 说明没有链表 2，直接返回
                if(i > 0) {
                    break;
                }

                i = intv;
                ListNode h2 = h;
                for (; h != null && i > 0; --i) {
                    h = h.next;
                }

                // 求出待 merge 的两个链表的长度
                int c1 = intv;
                int c2 = intv - i;

                // merge h1 and h2
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        --c1;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        --c2;
                    }
                    pre = pre.next;
                }
                pre.next = c1 > 0 ? h1 : h2;
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    --c1;
                    --c2;
                }

                pre.next = h;
            }
            intv *= 2;
        }

        return dummy.next;
    }

    private int getListLen(ListNode head) {
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        return len;
    }

}