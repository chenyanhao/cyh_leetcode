package p101_200.p165比较版本号;

/**
 * 模仿状态机编程，编写一个辅助函数，每次返回两个值，一个是当前 trunk 值，另一个是下一次的索引位置
 */
class Solution {

    private class Pair<T, U> {

        public Pair(T first, U second) {
            this.second = second;
            this.first = first;
        }

        public final T first;
        public final U second;
    }

    public int compareVersion(String version1, String version2) {
        Integer p1 = 0, p2 = 0;
        while (p1 < version1.length() || p2 < version2.length()) {
            Pair<Integer, Integer> trunk1 = getNextTrunk(version1, p1);
            Pair<Integer, Integer> trunk2 = getNextTrunk(version2, p2);

            int d1 = trunk1.first, d2 = trunk2.first;
            if (d1 < d2) {
                return -1;
            } else if (d1 > d2) {
                return 1;
            }

            p1 = trunk1.second + 1;
            p2 = trunk2.second + 1;
        }
        return 0;
    }

    /**
     *
     * @param s：输入的字符串，即 version
     * @param index：当前的起始索引。进入该方法时，表示当前 trunk 第一个字符的索引值；该方法返回时，表示 '.' 的索引值
     * @return：返回一个元组，first 表示当前 trunk 的 int 值，second 表示下一次的起始索引
     */
    private Pair<Integer, Integer> getNextTrunk(String s, Integer index) {
        int trunkValue = 0, nextIndex = index;
        while (nextIndex < s.length()) {
            char cur = s.charAt(nextIndex);
            if (Character.isDigit(cur)) {
                trunkValue = trunkValue * 10 + cur - '0';
                ++nextIndex;
            } else {
                break;
            }
        }
        return new Pair<>(trunkValue, nextIndex);
    }

    public static void main(String[] args) {
        String v1 = "1.01", v2 = "1.01.1";
        int res = new Solution().compareVersion(v1, v2);
        System.out.println(res);
    }

}