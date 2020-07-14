package p004;

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);

        int length = merged.length;
        int mid = merged.length / 2;
        if (length % 2 == 1) {
            return merged[mid];
        } else {
            return new Double(merged[mid] + merged[mid - 1]) / 2;
        }
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] result = new int[length];
        int i = 0, j = 0;
        int k = 0;
        while (i <= nums1.length - 1 && j <= nums2.length - 1) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        while (i <= nums1.length - 1) {
            result[k++] = nums1[i++];
        }
        while (j <= nums2.length - 1) {
            result[k++] = nums2[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        double middle = findMedianSortedArrays(nums1, nums2);
        System.out.println(middle);
    }

}