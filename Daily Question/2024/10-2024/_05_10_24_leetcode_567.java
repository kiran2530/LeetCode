/*
 *  Q) 567. Permutation in String
        Given two strings s1 and s2, return true if s2 contains a 
        permutation
        of s1, or false otherwise.
        In other words, return true if one of s1's permutations is the substring of s2.

    Example 1:
        Input: s1 = "ab", s2 = "eidbaooo"
        Output: true
        Explanation: s2 contains one permutation of s1 ("ba").
        
    Example 2:
        Input: s1 = "ab", s2 = "eidboaoo"
        Output: false
        
    Constraints:
        1 <= s1.length, s2.length <= 10^4
        s1 and s2 consist of lowercase English letters.
 */

import java.util.Arrays;

public class _05_10_24_leetcode_567 {
    public static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    static public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;
        
        s1 = sortString(s1);

        if(s1.length() == s2.length())
            return s1.equals(sortString(s2));

        int i=0, j=s1.length();

        while (j<=s2.length()) {
            if(s1.equals(sortString(s2.substring(i, j))) ) {
                return true;
            }
            i++;
            j++;
        }
        
        return false;
    }

    public static void main(String[] args) {
        String s1 = "islander", s2 = "islander";
        System.out.println(checkInclusion(s1, s2));
    }
}
