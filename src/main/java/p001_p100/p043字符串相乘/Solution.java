package p001_p100.p043字符串相乘;

import java.util.Arrays;

class Solution {
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int len = m + n;
        int[] result = new int[len];
        Arrays.fill(result, 0);
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + result[p2];
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        int start = 0;
        while (start < result.length && result[start] == 0) {
            ++start;
        }
        StringBuilder sb = new StringBuilder();
        for ( ; start < result.length; ++start) {
            sb.append(result[start]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String multiply = multiply(num1, num2);
        System.out.println(multiply);
    }
}