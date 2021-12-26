package p201_300.p240搜索二维矩阵2;

/**
 * 二分法的思想就是，目标值和中点值进行比较，然后可以丢弃一半的元素。
 *
 * 这道题是矩阵，所以找到矩阵的中心，和目标值比较看能不能丢弃一些元素：
 * 1）中心值小于目标值：由于左上角矩形中所有的数都小于目标值，所以可以丢弃左上角的矩形，继续从剩下三个矩形中寻找
 * 2）中心值大于目标值：由于右下角矩形中所有的数都大于目标值，所以可以丢弃右下角的矩形，继续从剩下三个矩形中寻找
 *
 */
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        /**
         * 对原矩阵建立指标坐标系，最左上角元素为坐标原点，往右为x轴正方向，往下为y轴正方向
         */
        return dfs(matrix, target,
                0, 0,
                matrix[0].length-1, matrix.length-1,
                matrix[0].length-1, matrix.length-1);
    }

    private boolean dfs(int[][] matrix, int target,
                        int x1, int y1, int x2, int y2,
                        int xMax, int yMax) {
        // 坐标越界
        if (x1 > xMax || y1 > yMax) {
            return false;
        }

        // 矩阵只有一个元素的情况
        if (x1 == x2 && y1 == y2) {
            return matrix[y1][x1] == target;
        }

        int m1 = (x1 + x2) / 2;
        int m2 = (y1 + y2) / 2;
        if (matrix[m2][m1] == target) {
            return true;
        } else if (matrix[m2][m1] < target) {
            return dfs(matrix, target, m1+1, y1, x2, m2, x2, y2) ||               // 右上矩阵
                    dfs(matrix, target, x1, m2 + 1, m1, y2, x2, y2) ||            // 左下矩阵
                    dfs(matrix, target, m1 + 1, m2 + 1, x2, y2, x2, y2);      // 右下矩阵
        } else {
            return dfs(matrix, target, m1 + 1, y1, x2, m2, x2, y2) ||             // 右上矩阵
                    dfs(matrix, target, x1, m2 + 1, m1, y2, x2, y2) ||            // 左下矩阵
                    dfs(matrix, target, x1, y1, m1, m2, x2, y2);                      // 左上矩阵
        }
    }
}