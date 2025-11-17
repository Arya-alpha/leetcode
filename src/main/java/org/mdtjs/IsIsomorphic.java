package org.mdtjs;

import java.util.HashMap;
import java.util.Map;

/**
 * 205.同构字符串
 *
 * @author Arya
 * @version v1.0
 * @since v1.0
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if ((s2t.containsKey(s.charAt(i)) && s2t.get(s.charAt(i)) != t.charAt(i)) || (t2s.containsKey(t.charAt(i)) && t2s.get(t.charAt(i)) != s.charAt(i))) {
                return false;
            } else {
                s2t.put(s.charAt(i), t.charAt(i));
                t2s.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
