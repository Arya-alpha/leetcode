package org.mdtjs.simple;

import java.util.HashMap;

/**
 * 169.多数元素
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElementHash(nums));
    }

    /**
     * 哈希表
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    private static int majorityElementHash(int[] nums) {
        int max = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int j : nums) {
            int num = map.containsKey(j) ? map.get(j) + 1 : 1;
            // 超过半数直接返回
            if (num > len / 2) {
                return j;
            }
            map.put(j, num);

            res = num > max ? j : res;
            max = Math.max(max, num);
        }
        return res;
    }
}
