package p201_300.p220存在重复元素3;


import java.util.TreeSet;

/**
 *
 * 将题意转化为程序语言即为：
 * 对于任意一个位置 i（假设其值为 u），希望在下标范围为 [max(0,i−k), i) 内，找到值范围在 [u−t, u+t] 的数。
 *
 * 一个直接想法是每次遍历到任意位置 i 的时候，往后检查 k 个元素，但这样做的复杂度是 O(nk) 的，会超时。
 * 显然需要优化「检查后 k 个元素」这一过程。
 *
 *
 * 可以使用一个「有序集合」去维护长度为 k 的滑动窗口内的数，该数据结构最好支持高效「查询」与「插入/删除」操作：
 *  - 查询：在「有序集合」中应用「二分查找」，快速找到「小于等于 u 的最大值」和「大于等于 u 的最小值」（即「有序集合」中的最接近 u 的数）。
 *  - 插入/删除：在往「有序集合」添加或删除元素时，能够在低于线性的复杂度内完成（维持有序特性）。
 *
 * 当「查询」动作和「插入/删除」动作频率相当时，更好的选择是使用「红黑树」。
 *
 * 一个细节：由于 nums 中的数较大，会存在 int 溢出问题，我们需要使用 long 来存储。
 *
 * 时间复杂度：红黑树查找和插入都是 O(logk) 复杂度。整体复杂度为 O(nlogk)
 * 空间复杂度：O(k)
 *
 *
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Long u = nums[i] * 1L; // 将 int 转为 long
            Long l = ts.floor(u);   // 从 ts 中找到小于等于 u 的最大值
            Long r = ts.ceiling(u); // 从 ts 中找到大于等于 u 的最小值
            if (l != null && u - l <= t) {
                return true;
            }
            if (r != null && r - u <= t) {
                return true;
            }

            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数，以维持滑动窗口大小为 k
            ts.add(u);
            if (i >= k) {
                ts.remove(nums[i - k] * 1L);
            }

        }
        return false;
    }
}