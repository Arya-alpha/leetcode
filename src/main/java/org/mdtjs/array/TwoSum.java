package org.mdtjs.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1.两数之和
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] sum = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] record = getTwoSum(sum, target);
        System.out.println(Arrays.toString(record));
    }

    public static int[] getTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
