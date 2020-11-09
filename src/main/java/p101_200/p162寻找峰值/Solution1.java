package p101_200.p162寻找峰值;

/**
 * 首先要注意题目条件，在题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着
 *      只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
 * 根据上述结论，就可以使用二分查找找到峰值，
 * 根据左右指针计算中间位置 m，比较 m 与 m+1 的值，
 *      - 如果 m 较大，则说明中值处在局部下降坡度中，左侧存在峰值，r = m，
 *      - 如果 m + 1 较大，说明中值处在局部上升坡度中，右侧存在峰值，l = m + 1
 *
 * 时间复杂度 : O(log2(n))。每一步都将搜索空间减半。
 * 空间复杂度: O(log2(n))。递归树的深度为 log2(n)。
 *
 */
class Solution1 {
    public int findPeakElement(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }

        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return dfs(nums, l, mid);
        } else {
            return dfs(nums, mid + 1, r);
        }

    }

}