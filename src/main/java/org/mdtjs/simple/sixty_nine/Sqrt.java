package org.mdtjs.simple.sixty_nine;

/**
 * 关于数值转换的说明
 * long t1 = mid * mid;         结果溢出，再转换为long
 * long t2 = (long) mid * mid;  先转换为long，再计算
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        int i = 0;
        int j = x;
        int ans = -1;
        while (i <= j) {
            int mid = (i + j) / 2;

            if ((long) mid * mid <= x) {
                i = mid + 1;
                ans = mid;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }
}
