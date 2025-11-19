package org.mdtjs.simple;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 2154.将找到的值乘以2
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class FindFinalValue {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 6, 1, 12};
        System.out.println(findFinalValue2(nums, 3));
    }

    // 哈希表
    public static int findFinalValue2(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(original)) {
            original = original * 2;
        }
        return original;
    }

    // 排序后查找
    public static int findFinalValue1(int[] nums, int original) {
        // 排序后直接向后遍历 -- 较慢
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == original) {
                original = original * 2;
            }
        }
        return original;

//        // 排序后二分法查找，找到后修改[low,high]区间值 -- 极慢
//        Arrays.sort(nums);
//        int low = 0;
//        int high = nums.length - 1;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (nums[mid] == original) {
//                original = original * 2;
//                low = mid + 1;
//                high = nums.length - 1;
//            }
//            if (nums[mid] > original) {
//                high = mid - 1;
//            }
//            if (nums[mid] < original) {
//                low = mid + 1;
//            }
//        }
//        return original;
    }
}
