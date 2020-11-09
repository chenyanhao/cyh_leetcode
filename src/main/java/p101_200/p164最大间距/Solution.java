package p101_200.p164最大间距;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过该题了解桶排序和基数排序
 */
class Solution {

    /**
     *
     * 这里是基数排序
     *
     * 从最低位开始，
     *  1. 按照个位数进行排序。
     *  2. 按照十位数进行排序。
     *  3. 按照百位数进行排序。
     * 排序后，数列就变成了一个有序序列。
     *
     * 比如这样一个数列排序： arr = [342 58 576 356]
     *  1) 对 arr 按照个位数排序后，得到 arr1 = [342 576 356 058]；
     *  2) 对 arr1 按照十位数排序，得到 arr2 = [342 356 058 576]；
     *  3) 对 arr2 按照十位数排序，得到 arr3 = [58 342 356 576]；
     *  4) arr3 即为最终排序结果
     *
     * 为了代码更好理解，直接用 10 个 list 去存放每一组的数字，其实可以直接用一维数组实现的。
     *
     */
    public int maximumGap(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }

        // 初始化基数数组，这里直接用 10 个 list
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            lists.add(new ArrayList<>());
        }

        // 找出最大的数字
        int max = nums[0];
        for (int n : nums) {
            max = Math.max(max, n);
        }

        int exp = 1;
        while (max > 0) { // 用 max 控制循环结束
            // 将之前的基数数组清空
            for (int i = 0; i < 10; ++i) {
                lists.set(i, new ArrayList<>());
            }

            // 将数字放入对应位置
            for (int n : nums) {
                lists.get(n / exp % 10).add(n);
            }

            // 将数字依次拿出来
            int index = 0;
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < lists.get(i).size(); ++j) {
                    nums[index] = lists.get(i).get(j);
                    ++index;
                }
            }

            max /= 10;
            exp *= 10;
        }

        int maxGap = 0;
        for (int i = 0; i < length - 1; ++i) {
            maxGap = Math.max(maxGap, nums[i+1] - nums[i]);
        }

        return maxGap;
    }
}






















