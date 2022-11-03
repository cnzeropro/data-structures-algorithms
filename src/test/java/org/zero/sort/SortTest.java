package org.zero.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Zero (cnzeropro@qq.com)
 * @date 2022/5/30
 */
class SortTest {
    int[] arr;

    @BeforeEach
    void setUp() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("nums.txt"), StandardCharsets.UTF_8));) {
            String numsStr = reader.lines().collect(Collectors.joining(""));
            arr = Arrays.stream(numsStr.split(",")).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            arr = new int[]{2, 4, 3, 1, 5, 7, 10, 8, 6, 9};
            e.printStackTrace();
        }
    }

    @Test
    void bubbleSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.bubbleSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void bubbleSortStrict() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.bubbleSortStrict(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void selectionSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.selectionSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void selectionSortStrict() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.selectionSortStrict(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void insertionSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.insertionSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void insertionSortStrict() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.selectionSortStrict(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void shellSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.shellSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void shellSortStrict() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.shellSortStrict(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void mergeSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.mergeSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void quickSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.quickSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void heapSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.heapSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void radixSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.radixSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void countingSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.countingSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void bucketSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.bucketSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void spaghettiSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.spaghettiSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void sleepSort() throws Exception {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.sleepSort(arr);
        long end = System.nanoTime();
        Thread.sleep(3000);
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void bogoSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.bogoSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }

    @Test
    void bogobogoSort() {
        System.out.println("排序前：" + Arrays.toString(arr));
        long start = System.nanoTime();
        Sort.bogobogoSort(arr);
        long end = System.nanoTime();
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("排序耗时：" + Duration.ofNanos(end - start));
    }
}