package p001_p100.p074搜索二维矩阵;

/**
 * 利用二维二分查找，先找行、再找列
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else if (target > matrix[mid][0]) {
                left = mid + 1;
            }
        }

        if (left == 0) {
            return false;
        }

        int[] arr = matrix[left-1];
        left = 0;
        right = arr.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            }
        }

        return false;
    }
}