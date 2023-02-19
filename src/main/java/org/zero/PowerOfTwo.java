package org.zero;

/**
 * @author Zero (cnzeropro@qq.com)
 * @date 2021/6/10
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        int num = quicklyGetPowerOfTwo(17);
        System.out.println(num);
        int n = howManyPowerOfTwo(num);
        System.out.println(n);
    }

    /**
     * 快速求2的整数次幂
     *
     * @param n
     * @return
     */
    public static int quicklyGetPowerOfTwo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("参数有误，请输入正整数");
        }
        return 1 << n;
    }

    /**
     * 判断一个正整数是否为2的整数次幂以及是2的多少次方（整数幂）
     *
     * @param num
     * @return
     */
    public static int howManyPowerOfTwo(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("参数有误，请输入正整数");
        }
        // 假设一个数num是2的整数幂，则这个数在2进制中表现形式必须为10，100，1000，10000，100000，...的形式；
        // 那么继续借用1的思路，则num-1一定是01，011，0111，0111，01111，...的形式
        if ((num & (num - 1)) != 0) {
            throw new IllegalArgumentException("参数有误，不是2的整数次幂");
        }
        // 对于num在2进制中表现形式，发现都是以1开头的字符串，该二进制字符串从右往左1对应的小标就是想要的答案
        // 为了避免逆向翻转字符串，直接用二进制字符串长度-1代替，效果一样
        return Integer.toBinaryString(num).length() - 1;
    }
}
