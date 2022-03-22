package p001_p100.p082删除排序链表中的重复元素2;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);

        ListNode p = this.next;
        while (p != null) {
            sb.append(" -> ");
            sb.append(p.val);
            p = p.next;
        }
        return sb.toString();
    }
}