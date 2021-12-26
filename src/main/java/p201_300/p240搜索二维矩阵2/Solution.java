package p201_300.p240搜索二维矩阵2;

/**
 * 观察右上角元素，它所在的行中，它是最大的；它所在的列中，它是最小的。
 *
 * 因此遍历策略就是二分查找的变种，即从右上角开始遍历，
 * 1）如果 target 的值小于当前值，也就意味着当前值所在的列肯定不会存在 target 了，可以把当前列去掉，从新的右上角的值开始遍历。
 * 2）如果 target 的值大于当前值，也就意味着当前值所在的行肯定不会存在 target 了，可以把当前行去掉，从新的右上角的值开始遍历。
 *
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0, col = matrix[0].length - 1;
        while (row <= matrix.length-1 && col >= 0) {
            if (target > matrix[row][col]) {
                ++row;
            } else if (target < matrix[row][col]) {
                --col;
            } else {
                return true;
            }
        }
        return false;
    }


}