package p085最大矩形;

class Solution {

    public int maximalRectangle(char[][] matrix) {
        return -1;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'1', '0', '0', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        int result = new Solution().maximalRectangle(matrix);
        System.out.println(result);
    }
}