package p101_200.p164最大间距;

import sun.lwawt.macosx.CInputMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过该题了解桶排序和基数排序
 */
class Solution2 {

    /**
     * 这里是桶排序。
     *
     * 例如，nums=[0, 3, 4, 6, 23, 28, 29, 33, 38]，将数字依次装到三个箱子里，
     *     0            1            2           3
     *  -------      -------      -------     -------
     * |  3 4  |    |       |    | 29    |   | 33    |
     * |   6   |    |       |    |  23   |   |       |
     * |  0    |    |       |    |  28   |   |  38   |
     *  -------      -------      -------     -------
     *   0 - 9       10 - 19      20 - 29     30 - 39
     * （把每个箱子的最大值和最小值表示出来）
     *  min  max     min  max     min  max  min  max
     *  0     6      -     -      23   29   33   38
     *
     * （这里桶的长度和个数是随便举例，方便理解）
     *
     *
     * 分桶的 长度 和 个数 是桶排序的关键，它们是由数组中最大值、最小值以及数组中的元素的个数来决定的，
     * 这样可以保证使用最少的桶覆盖所有的可能性。
     *
     * 桶长度的确定：
     *  桶长度 = 区间总长度 / 区间总个数 = (max - min) / (nums.length - 1)
     *
     * 桶个数的确定：
     *  桶个数 = (区间长度 / 桶长度) + 1
     *  这里 +1 是考虑到开闭区间的问题，例如 [2,4,6,8] 对应的分桶为 [2,4),[4,6),[6,8)，
     *  那 8 怎么办？多加一个桶，对应区间 [8,10)
     *
     * 按照以上去分桶，就可以保证：同一个桶里，绝对不会出现最大的相邻的差值！（因为以上分桶方式是按照数组完全均匀等差的方式去分配的，而实际情况并非等差。）
     * 所以只需要比较桶之间的差值即可得到最终结果了。
     *
     * 关键点：
     * 记录每个桶的最大值和最小值，然后拿这两个值去和相邻的桶的最大值和最小值做差。这样下来可以保证时间复杂度是 O(n) 的。
     *
     */
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        // 求出数组的 min 和 max 以确定 分桶数 和 分桶长度
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        // 桶长度 = 区间总长度 / 区间总个数 = (max - min) / (nums.length - 1)
        int bucketSize = Math.max(1, (max - min) / (nums.length - 1));
        // 桶个数 = (区间长度 / 桶长度) + 1
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];

        for (int i = 0; i < nums.length; ++i) {
            int location = (nums[i] - min) / bucketSize; // 计算在哪个分桶
            if (buckets[location] == null) {
                buckets[location] = new Bucket();
            }

            buckets[location].min = Math.min(buckets[location].min, nums[i]);
            buckets[location].max = Math.max(buckets[location].max, nums[i]);
        }

        int prev = -1; // 表示前一个桶的索引，初始化为 -1
        int maxGap = 0; // 表示桶之间的最大差值，初始化为 0
        for (int i = 0; i < buckets.length; ++i) {
            if (buckets[i] == null) {
                continue;
            }

            if (prev == -1) {
                prev = i;
                continue;
            }

            maxGap = Math.max(maxGap, buckets[i].min - buckets[prev].max);
            prev = i;
        }

        return maxGap;
    }


    private class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

}
























