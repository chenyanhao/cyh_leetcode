package p101_200.p179最大数;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        /**
         * 注意这里不能写成 (s1 + s2).compareTo(s2 + s1)
         * >0: s1 > s2    =0: s1=s2    <0: s1<s2
         *
         * 例 s1=3, s2=30   则s1+s2=330， s2+s1=303   故 s1 应排在 s2 前面，即要让 Comparator 认为 s1 < s2
         *
         */
        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // 排序后第一个数为 0，那么直接返回 0
        if (strs[0].equals("0")) {
            return "0";
        }

        return Arrays.stream(strs).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String result = new Solution().largestNumber(nums);
        System.out.println(result);
    }

}