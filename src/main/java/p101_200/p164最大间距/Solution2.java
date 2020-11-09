package p101_200.p164最大间距;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过该题了解桶排序和基数排序
 */
class Solution2 {

    /**
     * 这里是桶排序。
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

        int previousMax = Integer.MAX_VALUE;
        int maxGap = Integer.MIN_VALUE;
        for (Bucket bucket : buckets) {
            if (bucket != null && previousMax != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, bucket.min - previousMax); // 桶间
            }

            if (bucket != null) {
                previousMax = bucket.max;
                maxGap = Math.max(maxGap, bucket.max - bucket.min);  // 桶内
            }
        }

        return maxGap;
    }


    private class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

}
























