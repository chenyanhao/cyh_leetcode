package p201_300.p215数组中的第K个最大元素;

/**
 * 基于堆排序，建立一个大顶堆，做 k−1 次删除操作后，堆顶元素即为所求
 *
 * 时间复杂度：O(nlogn)，建堆的时间代价是 O(n)，删除的总代价是 O(klogn)，因为 k<n，故渐进时间复杂为 O(n+klogn)=O(nlogn)。
 * 空间复杂度：O(log n)，递归使用的栈空间
 *
 *
 * 用数组顺序存储二叉堆，
 * 1）第 n 个元素的 左子节点为 2*n+1
 * 2）第 n 个元素的 右子节点为 2*n+2，可以理解为 right = left + 1
 * 3）第 n 个元素的 父节点为 (n-1)/2
 * 4）最后一个非叶子节点为 Math.floor(arr.length/2)-1
 *
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }


    private void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize/2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    private void maxHeapify(int[] a, int i, int heapSize) {
        int l = 2 * i + 1, r = 2 * i + 2;
        int largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }

        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
