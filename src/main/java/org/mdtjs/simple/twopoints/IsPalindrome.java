package org.mdtjs.simple.twopoints;

/**
 * 125.验证回文串
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String s1 = ".,";
        String s2 = "0P";
        System.out.println(solution(s2));
    }

    public static boolean solution(String s) {
        if (s.length() <= 1) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i > j || Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
