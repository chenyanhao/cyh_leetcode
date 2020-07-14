package p007整数反转;

class Solution {
    public static int reverse(int x) {
        int res = reverse4Positive(Math.abs(x));
        if (x < 0) {
            return -res;
        } else {
            return res;
        }
    }

    public static int reverse4Positive(int x) {
        String s = String.valueOf(x);
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            ++left;
            --right;
        }
        String reversed = String.valueOf(arr);
        try {
            return Integer.valueOf(reversed).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int x = 2147481199;
        int res = reverse4Positive(x);
        System.out.println(res);
    }
}


