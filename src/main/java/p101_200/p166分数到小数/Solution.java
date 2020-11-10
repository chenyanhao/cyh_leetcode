package p101_200.p166分数到小数;

import java.util.HashMap;
import java.util.Map;

/**
 * 几个注意点依次为：边界条件、防止溢出、处理正负号
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 边界条件
        if (denominator == 0) { // 分母为零
            return "";
        }
        if (numerator == 0) { // 分子为零
            return "0";
        }

        // 转换为 long，防止溢出
        long num = numerator;
        long denom = denominator;

        StringBuilder sb = new StringBuilder();
        // 处理正负号
        if ((num > 0) ^ (denom > 0)) {
            sb.append("-");
        }

        // 分子分母全转化为正数
        num = Math.abs(num);
        denom = Math.abs(denom);

        // 处理整数部分
        sb.append(num / denom);

        // 处理小数部分
        num %= denom;
        if (num == 0) { // 余数为 0，直接返回
            return sb.toString();
        }

        sb.append("."); // 余数不为 0，添加小数点

        Map<Long, Integer> record = new HashMap<>(); // map 用来记录出现重复数的下标
        int index = sb.length()-1; // 获得小数点的下标
        while (num != 0 && ! record.containsKey(num)) { // 小数部分：余数不为 0 且余数还没有出现重复数字
            record.put(num, ++index);

            // 余数扩大 10 倍，然后求商，和手写的运算方式是一样的
            num *= 10;
            sb.append(num / denom);
            num %= denom;
        }

        if (record.containsKey(num)) {
            sb.insert(record.get(num), "(");
            sb.append(")");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int numerator = 4;
        int denominator = 33;
        String res = new Solution().fractionToDecimal(numerator, denominator);
        System.out.println(res);
    }
}




















