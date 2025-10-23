package org.mdtjs.simple.dp;

/**
 * 746.使用最小花费爬楼梯
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};
        System.out.println(solution(cost));
    }

    public static int solution(int[] cost) {
        int len = cost.length;
        int[] arr = new int[len];
        arr[0] = cost[0];
        arr[1] = cost[1];
        for (int i = 2; i < len; i++) {
            int min = Math.min(arr[i - 1], arr[i - 2]);
            arr[i] = min + cost[i];
        }
        return Math.min(arr[cost.length - 1], arr[cost.length - 2]);
    }
}
