package org.mdtjs.simple.array;

/**
 * 717.1比特与2比特字符
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class IsOneBitCharacter {

    public static void main(String[] args) {
        int[] bits = new int[]{1,1,1,0};
        System.out.println(isOneBitCharacter(bits));
    }

    private static boolean isOneBitCharacter(int[] bits) {
        int size = bits.length;
        if (size <= 1) {
            return bits[0] == 0;
        }

        int nextIndex = -1;
        for (int i = size - 2; i >= 0; i--) {
            if (bits[i] == 0) {
                nextIndex = i;
                break;
            }
        }

        return (size - nextIndex - 2) % 2 == 0;
    }
}
