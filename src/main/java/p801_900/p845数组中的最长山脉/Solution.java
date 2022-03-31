package p801_900.p845数组中的最长山脉;

/**
 * 维护两个 DP 数组，left[i]表示第i个元素最多能向左扩展多少个元素，right[i]表示其最多能向右扩展多少个元素。
 *
 * left[i] = arr[i-1] < arr[i] ? left[i-1] + 1 : 0
 * right[i] = right[i] > right[i+1] ? right[i+1] + 1 : 0
 */
class Solution {
    public int longestMountain(int[] arr) {
        // left 数组从左向右遍历
        int[] left = new int[arr.length];
        for (int i = 1; i < arr.length; ++i) {
            left[i] = arr[i-1] < arr[i] ? left[i-1] + 1 : 0;
        }

        // right 数组从右向左遍历
        int[] right = new int[arr.length];
        for (int i = arr.length-1 - 1; i >= 0; --i) {
            right[i] = arr[i] > arr[i+1] ? right[i+1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < arr.length; ++i) {
            // 注意这种 badcase，arr=[2,2,2]。需要真正能形成山脉的情况下再更新 ans
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }

        return ans;
    }
}