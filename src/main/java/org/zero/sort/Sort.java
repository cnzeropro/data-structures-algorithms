package org.zero.sort;

import java.util.Arrays;
import java.util.concurrent.FutureTask;

/**
 * @author Zero (cnzeropro@qq.com)
 * @date 2022/5/30
 */
public class Sort {

    /**
     * 冒泡排序
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble sort</a>
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 严格冒泡排序
     * <p>
     * 如果某次冒泡排序后，没有发生交换，则说明数组已经有序，可以结束排序
     * 如果某次冒泡排序后，发生了交换，则说明数组还未有序，需要继续排序
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble sort</a>
     */
    public static void bubbleSortStrict(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean isSorted = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 选择排序
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection sort</a>
     */
    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * 严格选择排序
     * <p>
     * 如果某次选择排序后，没有发生交换，则说明数组已经有序，可以结束排序
     * 如果某次选择排序后，发生了交换，则说明数组还未有序，需要继续排序
     * </p>
     * todo:
     * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection sort</a>
     */
    public static void selectionSortStrict(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            } else {
                break;
            }
        }
    }

    /**
     * 插入排序
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort">Insertion sort</a>
     */
    public static void insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * 严格插入排序
     * <p>
     * 如果某次插入排序后，没有发生交换，则说明数组已经有序，可以结束排序
     * 如果某次插入排序后，发生了交换，则说明数组还未有序，需要继续排序
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort">Insertion sort</a>
     */
    public static void insertionSortStrict(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
            if (j == -1) {
                break;
            }
        }
    }

    /**
     * 希尔排序
     * <p>
     * 希尔排序是插入排序的一种更高效的改进版本，其基本思想是：
     * 将数组分割成若干个子数组，每个子数组中的元素都是有序的，然后对每个子数组进行插入排序
     * 时间复杂度：O(n^1.3–1.5)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Shellsort">Shell sort</a>
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap /= 2;
        }
    }

    /**
     * 严格希尔排序
     * <p>
     * 希尔排序的分析是一个复杂的问题，它的时间是所取“增量”序列决定的，但目前好像还没有严谨的数学分析
     * 所谓严格希尔排序，也只不过是尽量提高其时间复杂度而已，增量序列的选取目前尚未有一个严谨准确的值
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Shellsort#Strict_shellsort">Strict Shell sort</a>
     */
    public static void shellSortStrict(int[] arr) {
        int len = arr.length;
        int gap = 1;
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap /= 3;
        }
    }

    /**
     * 归并排序
     * <p>
     * 归并排序是一种分治算法，其基本思想是：
     * 将原始数组分成若干个子数组，每个子数组中的元素都是有序的，然后对每个子数组进行排序，最后将所有子数组合并成一个有序的数组
     * 时间复杂度：O(n*log(n))
     * 空间复杂度：O(n)
     * 稳定性：稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge sort</a>
     */
    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        mergeSort(arr, temp, 0, len - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int m = left; m <= right; m++) {
            arr[m] = temp[m];
        }
    }

    /**
     * 快速排序
     * <p>
     * 快速排序是对冒泡排序算法的一种改进，其基本思想是：
     * 1. 将数组分成两个子数组，一个子数组中的元素都比较小，另一个子数组中的元素都比较大
     * 2. 对这两个子数组分别进行快速排序，然后将两个子数组合并成一个有序的数组
     * 3. 对整个数组进行重复上述操作，直到数组中的元素都有序
     * 时间复杂度：O(n*log(n))
     * 空间复杂度：O(log(n))
     * 稳定性：不稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Quicksort">Quicksort</a>
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    /**
     * 堆排序
     * <p>
     * 堆排序是一种树形选择排序，其基本思想是：
     * 1. 将待排序的数组构建成一个大顶堆，此时堆顶元素的值最大，然后将堆顶元素和最后一个元素交换
     * 2. 将剩余n-1个元素重新构建成一个堆，此时堆顶元素的值最大，然后将堆顶元素和最后一个元素交换
     * 3. 重复步骤2，直到只有一个元素为止
     * 时间复杂度：O(n*log(n))
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Heapsort">Heapsort</a>
     */
    public static void heapSort(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapAdjust(arr, i, 0);
        }
    }

    private static void heapAdjust(int[] arr, int len, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapAdjust(arr, len, largest);
        }
    }

    /**
     * 基数排序
     * <p>
     * 基数排序是属于“分配式排序”的一种，其分配原则为：
     * 首先将整数按最低有效位到最高有效位的顺序排列，然后依次按每一位的大小对排序后的数列进行分配
     * 基数排序的核心在于将整数按位切割，然后对每一位上的数字进行排序
     * 时间复杂度：O(n*k)
     * 空间复杂度：O(n+k)
     * 稳定性：不稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Radix_sort">Radix sort</a>
     */
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int exp = 1;
        while (max / exp > 0) {
            int[] bucket = new int[10];
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / exp) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            int[] temp = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[--bucket[(arr[i] / exp) % 10]] = arr[i];
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = temp[i];
            }
            exp *= 10;
        }
    }

    /**
     * 计数排序
     * <p>
     * 计数排序是一种稳定的排序算法，其基本思想是：
     * 1. 初始化一个数组C，其中第i个元素为0，
     * 2. 遍历数组A，对于每个元素A[i]，把C[A[i]]+1
     * 3. 遍历数组C，把C中的元素放到A的对应位置
     * 时间复杂度：O(n+k)
     * 空间复杂度：O(n+k)
     * 稳定性：稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Counting_sort">Counting sort</a>
     */
    public static void countingSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[--bucket[arr[i]]] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * 桶排序
     * <p>
     * 桶排序是计数排序的升级版，它的基本思想是：
     * 1. 将数组分到有限数量的桶里，每个桶再分别排序
     * 2. 从桶中取出序列，再排序
     * 3. 桶的数量通常是2的幂，比如2、4、8、16、32...
     * 4. 桶的大小通常是数组中的数值范围的一半
     * 时间复杂度：O(n+k)
     * 空间复杂度：O(n+k)
     * 稳定性：稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bucket_sort">Bucket sort</a>
     */
    public static void bucketSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int bucketSize = max / arr.length;
        int bucketNum = max / bucketSize + 1;
        int[][] bucket = new int[bucketNum][];
        for (int i = 0; i < bucketNum; i++) {
            bucket[i] = new int[0];
        }
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] / bucketSize;
            bucket[index] = Arrays.copyOf(bucket[index], bucket[index].length + 1);
            bucket[index][bucket[index].length - 1] = arr[i];
        }
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            if (bucket[i].length > 0) {
                Arrays.sort(bucket[i]);
                for (int j = 0; j < bucket[i].length; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
        }
    }

    /**
     * 意面排序
     *
     * @see <a href="https://en.wikipedia.org/wiki/Spaghetti_sort">Spaghetti sort</a>
     */
    public static void spaghettiSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 睡眠排序
     *
     * @see <a href="https://en.wikipedia.org/wiki/Sleep_sort">Sleep sort</a>
     */
    public static void sleepSort(int[] arr) throws Exception {
        int len = arr.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            int[] finalArr = arr;
            int finalI = i;
            FutureTask<Integer> futureTask = new FutureTask<>(() -> {
                try {
                    Thread.sleep(finalArr[finalI]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return finalArr[finalI];
            });
            new Thread(futureTask).start();
            temp[i] = futureTask.get().intValue();
        }
        arr = temp;
    }

    /**
     * 猴子排序
     * <p>
     * 猴子排序是一种量子化随机排列，它的基本思想是：
     * 如果这组数没有被排列好，那么我们就再洗一次牌，直到它排列好为止
     * 时间复杂度: O(n*n!)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bogosort">Bogosort</a>
     */
    public static void bogoSort(int[] arr) {
        int len = arr.length;
        while (!isSorted(arr)) {
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    /**
     * 蠢猴排序
     * <p>
     * 又称人品排序法，检验人品的时间到了
     * 时间复杂度: O(n*n!^n)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定
     * </p>
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bogobogo_sort">Bogobogo sort</a>
     */
    public static void bogobogoSort(int[] arr) {
        int len = arr.length;
        while (!isSorted(arr)) {
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            for (int i = len - 1; i > 0; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }
    }

    private static boolean isSorted(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
