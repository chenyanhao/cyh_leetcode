package p201_300.p220存在重复元素3;


import java.util.HashMap;
import java.util.Map;

/**
 * 基于桶排序思想。
 *
 * 解法一无法做到线性时间复杂度的原因是：要在大小为 k 的滑动窗口所在的「有序集合」中找到与 u 接近的数。
 * 如果能够将 k 个数字分到 k 个桶的话，那么我们就能 O(1) 的复杂度确定是否有 [u−t,u+t] 的数字（检查目标桶是否有元素）。
 *
 *
 * 举个例子，某天老师让全班同学各自说出自己的出生日期，然后统计一下出生日期相差小于等于30天的同学。很容易想到，
 *  - 出生在同一个月的同学，一定满足上面的条件。
 *  - 出生在相邻月的同学，也有可能满足那个条件，这就需要计算一下来确定了。
 *  - 如果月份之间相差了两个月，那就不可能满足这个条件了。
 *
 *
 * 具体的做法为，根据 u 计算所在桶编号：
 *  - 如果已经存在该桶，说明前面已有 [u−t,u+t] 范围的数字，返回 true
 *  - 如果不存在该桶，则检查相邻两个桶的元素是有 [u−t,u+t] 范围的数字，如有 返回 true
 *  - 建立目标桶，并删除下标范围不在 [max(0,i−k),i) 内的桶
 *
 *
 * 因为一个桶内至多只会有一个元素，所以使用哈希表实现即可。
 *
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(k)
 *
 */
class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long u = nums[i] * 1L;
            long idx = getIdx(u, t);

            // 目标桶已存在，说明前面已有 [u - t, u + t] 范围的数字
            if (map.containsKey(idx)) {
                return true;
            }

            // 检查相邻的桶
            long l = idx - 1, r = idx + 1;
            if (map.containsKey(l) && u - map.get(l) <= t) {
                return true;
            }
            if (map.containsKey(r) && map.get(r) - u <= t) {
                return true;
            }

            // 建立目标桶，并移除下标范围不在 [max(0, i - k), i) 内的桶
            map.put(idx, u);
            if (i >= k) {
                map.remove(getIdx(nums[i - k] * 1L, t));
            }
        }
        return false;
    }

    /**
     * nums 数组既有整数也有负数，所以要处理正负数的情况
     */
    private long getIdx(long u, long size) {
        if (u >= 0) {
            return u / (size + 1);
        }
        return ((u + 1) / (size + 1)) - 1;
    }

}