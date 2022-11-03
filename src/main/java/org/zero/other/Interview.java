package org.zero.other;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 面试问题合集
 *
 * @author Zero (cnzeropro@qq.com)
 * @date 2022/5/30
 */
public class Interview {
    /**
     * 统计字符串中每个字符出现的次数
     */
    public static Map<Character, Integer> countingStr(String str) {
        Map<Character, Integer> map = new HashMap<>(str.length());
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        return map;
    }

    /**
     * 将两个有序数组合并为一个有序数组
     */
    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            arr[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }

        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }

        return arr;
    }

    /**
     * 将两个有序列表合并为一个新的有序列表
     */
    public static List<Integer> mergeSortedList(List<Integer> list1, List<Integer> list2) {
        list1.addAll(list2);
        Collections.sort(list1);
        list1.sort(Comparator.naturalOrder());
        return list1;
    }

    /**
     * 求列表交集
     */
    public static List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
        // 传入Arrays.asList方法转换的集合会抛出异常
        // 方法1
//        list1.retainAll(list2);
//        return list1;

        // 方法2
//        List<Integer> list = new ArrayList<>();
//        for (Integer i1 : list1) {
//            for (Integer i2 : list2) {
//                if (i1.equals(i2)) {
//                    list.add(i1);
//                }
//            }
//        }
//        return list;

        // 方法3
        return list1.stream().filter(list2::contains).collect(Collectors.toList());
    }
}
