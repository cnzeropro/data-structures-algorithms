package org.zero;

/**
 * Fast Inverse Square Root（快速平方根倒数算法）
 * 快速求1/sqrt(x)，大约是普通方式的4倍
 *
 * @author Zero (cnzeropro@qq.com)
 * @date 2021/5/30
 * @see <a href="https://en.wikipedia.org/wiki/Fast_inverse_square_root">Fast inverse square root</a>
 */
public class FastInvSqrt {
    public static double invSqrt(double x) {
        double xhalf = 0.5d * x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i >> 1);
        x = Double.longBitsToDouble(i);
        x *= (1.5d - xhalf * x * x);
        return x;
    }

    public static float invSqrt(float x) {
        float xhalf = 0.5f * x;
        int i = Float.floatToIntBits(x);
        i = 0x5f3759df - (i >> 1);
        x = Float.intBitsToFloat(i);
        x *= (1.5f - xhalf * x * x);
        return x;
    }
}
