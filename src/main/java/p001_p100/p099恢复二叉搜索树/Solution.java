package p001_p100.p099恢复二叉搜索树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * 1）按中序遍历树。遍历后的数组应该是递增序的列表，其中只有两个元素被交换。
     * 2）确定 1 中数组中的两个交换元素 x 和 y。
     * 3）再次遍历树，将值 x 的节点改为 y，将值 y 的节点改为 x。
     */
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        doRecover(root, 2, swapped[0], swapped[1]);
    }

    /**
     * 遍历树，将值 x 的节点改为 y，将值 y 的节点改为 x。
     */
    private void doRecover(TreeNode root, int count, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.val == x || root.val == y) {
            --count;
            root.val = root.val == x ? y : x;
        }

        if (count == 0) {
            return;
        }

        doRecover(root.left, count, x, y);
        doRecover(root.right, count, x, y);
    }


    /**
     * 中序遍历树
     */
    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

    /**
     *
     * 对于有序数组 [1, 2, 3, 4, 5, 6, 7, 8. 9]，此时交换两个数字，分为两种情况：
     * 1）交换的两个数字不相邻，例如交换 3 和 7，
     *  [1, 2, 7, 4, 5, 6, 3, 8. 9]
     *         -----    -----
     *         x           y
     *  有两个地方满足 nums[i] > nums[i+1]，即上面虚线标记的部分。
     *  第一次满足条件时，得到 x 的值；第二次满足条件时，得到 y 的值。
     * 2) 交换的两个数字相邻，例如 3 和 4，
     *  [1, 2, 4, 3, 5, 6, 7, 8. 9]
     *         -----
     *         x  y
     *  只有一个地方满足 nums[i] > nums[i+1]，即上面虚线标记的部分。
     *
     */
    private int[] findTwoSwapped(List<Integer> nums) {
        int x = -1, y = -1;
        for (int i = 0; i < nums.size() - 1; ++i) {
            if (nums.get(i) > nums.get(i + 1)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[] {x, y};
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 2, 4);
        int[] swapped = new Solution().findTwoSwapped(nums);
        System.out.println(swapped[0] + "   " + swapped[1]);
    }
}