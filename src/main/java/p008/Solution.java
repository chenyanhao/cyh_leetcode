package p008;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int myAtoi(String str) {

        char[] arr = str.toCharArray();
        int n = arr.length;
        int idx = 0;

        // 去掉前导5空格
        while (idx < n && arr[idx] == ' ') {
            ++idx;
        }
        if (idx == n) {
            return 0;
        }

        // 处理第一位
        boolean negative = false;
        if (arr[idx] == '-') {
            negative = true;
            ++idx;
        } else if (arr[idx] == '+') {
            ++idx;
        } else if (!Character.isDigit(arr[idx])){
            return 0;
        }

        int ans = 0;
        while (idx < n && Character.isDigit(arr[idx])) {
            int digit = arr[idx] - '0';
            // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
            // 但是 * 10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            ++idx;
        }


        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
        String s = "-0012";
        int result = myAtoi(s);
        System.out.println(result);
    }
}