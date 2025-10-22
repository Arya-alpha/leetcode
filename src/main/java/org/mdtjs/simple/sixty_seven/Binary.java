package org.mdtjs.simple.sixty_seven;

/**
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class Binary {

    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));
    }

    public static String addBinary(String a, String b) {
        int flag = 0;
        StringBuilder res = new StringBuilder();

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sum += flag;
            res.append(sum % 2);
            flag = sum / 2;
        }
        res.append(flag == 0 ? "" : flag);
        return res.reverse().toString();
    }

    public static String addBinary2(String a, String b) {
        int flag = 0;
        String res = "";

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sum += flag;
            res = sum % 2 + res;
            flag = sum / 2;
        }

        return flag == 0 ? res : flag + res;
    }
}
