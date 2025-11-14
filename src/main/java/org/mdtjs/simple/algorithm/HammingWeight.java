package org.mdtjs.simple.algorithm;

/**
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class HammingWeight {

    public static void main(String[] args) {
        System.out.println("循环检查，结果：" + hammingWeight0(2147483645));
        System.out.println("位运算，结果：" + hammingWeight1(2147483645));
    }

    // 循环检查
    public static int hammingWeight0(int n) {
        int count = 0;
        String binary = Integer.toBinaryString(n);
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    // 位运算
    public static int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count ++;
        }
        return count;
    }
}
