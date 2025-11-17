package org.mdtjs.simple;

/**
 * 202.快乐数
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class IsHappy {

    public static void main(String[] args) {
        System.out.println(isHappy(3));
    }

    public static boolean isHappy(int n) {
        int slow = getSum(n);
        if (slow == 1) {
            return true;
        }

        int fast = getSum(slow);
        while (fast != 1 && fast != slow) {
            slow = getSum(slow);
            fast = getSum(fast);
            fast = getSum(fast);
        }

        return fast == 1;
    }

    private static int getSum(int n) {
        String str = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum = sum + (str.charAt(i) - '0') * (str.charAt(i) - '0');
        }
        return sum;
    }
}
