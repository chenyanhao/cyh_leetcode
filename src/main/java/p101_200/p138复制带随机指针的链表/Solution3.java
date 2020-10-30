package p101_200.p138复制带随机指针的链表;

class Solution3 {

    /**
     * 之前解法空间复杂度为 O(N)，空间复杂度可以优化到 O(1)
     *
     * 一、遍历原来的链表并拷贝每一个节点，将拷贝节点放在原来节点的旁边，创造出一个旧节点和新节点交错的链表。
     *  假设原始链表为 A->B->C，创造出的交错链表为 A->A'->B->B'->C->C'
     *
     * 二、迭代这个新旧节点交错的链表，并用旧节点的 random 指针去更新对应新节点的 random 指针。
     *  比如，B 的 random 指针指向 A ，则 B' 的 random 指针指向 A' 。
     *
     * 三、至此，random 指针已经被赋值给正确的节点，接下来将 next 指针正确赋值，以便将新的节点正确链接同时将旧节点重新正确链接。
     *  例如，上一步的链表为 A->A'->B->B'->C->C'，next 指针正确赋值后将变为两个链表，A->B->C 和 A'->B'->C'
     *
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 一、构造交错链表
        Node wavedCur = head; // 交错链表的头节点指针
        while (wavedCur != null) {
            // 克隆节点
            Node newNode = new Node(wavedCur.val);

            //  A->B->C，clone 并构造 A->A'->B->B'->C->C'
            newNode.next = wavedCur.next;
            wavedCur.next = newNode;
            wavedCur = newNode.next;
        }

        // 二、迭代交错链表，更新 cloned 节点的 random 指针
        wavedCur = head;
        while (wavedCur != null) {
            wavedCur.next.random = (wavedCur.random == null) ? null : wavedCur.random.next;
            wavedCur = wavedCur.next.next;
        }

        // 三、将交错链表拆分为两个单链表
        Node oldCur = head;
        Node clonedCur = head.next;
        Node retNode = clonedCur; // 记录下 A'->B'->C' 的头结点，作为最终结果返回
        while (oldCur != null) {
            oldCur.next = oldCur.next.next;
            clonedCur.next = (clonedCur.next == null) ? null : clonedCur.next.next;

            oldCur = oldCur.next;
            clonedCur = clonedCur.next;
        }

        return retNode;
    }

}