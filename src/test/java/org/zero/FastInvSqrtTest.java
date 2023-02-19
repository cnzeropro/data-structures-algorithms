package org.zero;

import org.junit.jupiter.api.Test;

/**
 * @author Zero (cnzeropro@qq.com)
 * @date 2021/5/30
 */
class FastInvSqrtTest {

    @Test
    void invSqrt() {
        long start = System.nanoTime();
        System.out.println(FastInvSqrt.invSqrt(2.0d));
        long end = System.nanoTime();
        System.out.println("FastInvSqrt.invSqrt(2.0d)耗时：" + (end - start) + "ns");

        start = System.nanoTime();
        System.out.println(FastInvSqrt.invSqrt(2.0f));
        end = System.nanoTime();
        System.out.println("FastInvSqrt.invSqrt(2.0f)耗时：" + (end - start) + "ns");

        start = System.nanoTime();
        System.out.println(1 / Math.sqrt(2));
        end = System.nanoTime();
        System.out.println("1/Math.sqrt(2)耗时：" + (end - start) + "ns");
    }
}