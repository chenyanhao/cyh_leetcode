package 框架代码.堆排序;

/**
 * 完全二叉堆几个结论：
 * 1）索引为i的节点，两个子节点是 2i+1 和 2i+2，父节点的索引是 (i-1)/2。（i的下标从0开始）
 * 2）数组的前一半都是非叶子节点，数组后一半都是叶子节点。
 *
 * 堆中有两种操作方法，一种叫 sink，一种叫 swim。
 * swim是指将节点n和它的父节点比较，如果它的父节点小于它，则节点n与它的父节点交换。然后再继续与它交换后的父节点进行比较，直到父节点不小于它为止。
 * sink则相反，节点n将于它的两个子节点比较，当它的子节点大于它时，它将于较大的那个子节点进行交换，以此类推不断重复。
 *
 * 如果是要通过堆来排序的话，通过 swim 的方式需要遍历整个数组，而通过 sink 的方式只需要遍历一半数组（因为叶子节点没有子节点），所以一般排序用途会使用 sink 方式
 */
public class 下沉堆排序 {
    public void heapSort(int[] arr) {
        int heapSize = arr.length;
        // 构造大顶堆，构造完后，根节点是数组中最大的值。
        for (int i = heapSize/2; i >= 0; --i) {
            sink(arr, i, heapSize);
        }

        // 依次把最大的数组元素移到数组的最右端
        for (int i = heapSize-1; i >= 0; --i) {
            swap(arr, 0, i);
            sink(arr, 0, i);
        }
    }

    // 递归实现sink
    public void sinkRecur(int[] arr, int i, int heapSize) {
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;

        // 找到当前节点i，及其两个子节点，三者中的最大者
        int largest = i;
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(arr, i, largest);
            sinkRecur(arr, largest, heapSize);
        }
    }

    // 循环实现sink
    public void sink(int[] arr, int i, int heapSize) {
        while (2*i+1 < heapSize) { // 该节点存在至少一个子节点
            int j = 2*i + 1;
            if (j+1 < heapSize && arr[j] < arr[j+1]) { // 取得子节点中的较大者
                ++j;
            }

            if (arr[i] > arr[j]) {
                break;
            }

            swap(arr, i, j);
            i = j;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,6,77,8,5,2,4,56,9,0};
        new 下沉堆排序().heapSort(arr);
        for (int e : arr) {
            System.out.println(e);
        }
    }
}
