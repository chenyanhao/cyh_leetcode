package p101_200.p143重排链表;

import java.util.ArrayList;
import java.util.List;

/**
 * 空间换时间，用数组存储链表节点
 */
class Solution {
    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            ++i;
            if (i == j) {
                break;
            }

            list.get(j).next = list.get(i);
            --j;
        }

        list.get(i).next = null;
    }
}