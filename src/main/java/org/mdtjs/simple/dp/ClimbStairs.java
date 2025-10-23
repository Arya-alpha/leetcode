package org.mdtjs.simple.dp;

/**
 * 70.爬楼梯
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(solution(1));
    }

    public static int solution(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}
