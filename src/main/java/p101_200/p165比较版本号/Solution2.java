package p101_200.p165比较版本号;

/**
 * 解法一过于炫技，这里给出正常解法
 */
class Solution2 {

    public int compareVersion(String version1, String version2) {
        int p1 = 0, p2 = 0;
        while (p1 < version1.length() || p2 < version2.length()) {
            int nums1 = 0;
            while (p1 < version1.length() && version1.charAt(p1) != '.') {
                nums1 = nums1 * 10 + version1.charAt(p1) - '0';
                ++p1;
            }

            int nums2 = 0;
            while (p2 < version2.length() && version2.charAt(p2) != '.') {
                nums2 = nums2 * 10 + version2.charAt(p2) - '0';
                ++p2;
            }

            if (nums1 > nums2) {
                return 1;
            } else if (nums1 < nums2) {
                return -1;
            }

            ++p1;
            ++p2;
        }

        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.01", v2 = "1.01.1";
        int res = new Solution2().compareVersion(v1, v2);
        System.out.println(res);
    }

}