package org.mdtjs.kmp;

/**
 * 28.找出字符串中第一个匹配项的下标
 */
public class MatchStr {

    public static void main(String[] args) {
        String haystack = "abeababeabf";
        String needle = "acaceacacc";
        int result = strStrKmp(haystack, needle);
        System.out.println(result);
    }

    // KMP
    public static int strStrKmp(String haystack, String needle) {

        int[] next = new int[needle.length()];
        // 当前位置最长匹配的长度
        int j = 0;

        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        // todo

        return -1;
    }

    // 暴力解法
    public static int strStrForce(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        // 首次完全匹配的长串索引
        int index = -1;
        // 下次匹配的初始索引
        int offset = 0;

        for (int j = 0; j < haystack.length() - needle.length() + 1; j++) {
            int start = Math.max(j, offset);
            int needleIndex = 0;
            boolean flag = false;
            for (int i = start; i < haystack.length(); i++) {
                char ch = haystack.charAt(i);
                if (ch == needle.charAt(0) && !flag) {
                    offset = i;
                    flag = true;
                }
                // 不匹配退出当前循环
                if (ch != needle.charAt(needleIndex)) {
                    break;
                }
                // 最后一位匹配直接终止循环
                if (ch == needle.charAt(needleIndex) && needleIndex == needle.length() - 1) {
                    index = i - needleIndex;
                    break;
                }
                needleIndex++;
            }
            if (index != -1) {
                break;
            }
        }

        return index;
    }
}
