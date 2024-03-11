import java.util.HashMap;
/*
 * 791. Custom Sort String
    - You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
    - Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
    - Return any permutation of s that satisfies this property.

    Example 1:
    Input:  order = "cba", s = "abcd" 
    Output:  "cbad" 
    Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
    Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.

    Example 2:
    Input:  order = "bcafg", s = "abcd" 
    Output:  "bcad" 
    Explanation: The characters "b", "c", and "a" from order dictate the order for the characters in s. The character "d" in s does not appear in order, so its position is flexible. 
    Following the order of appearance in order, "b", "c", and "a" from s should be arranged as "b", "c", "a". "d" can be placed at any position since it's not in order. The output "bcad" correctly follows this rule. Other arrangements like "bacd" or "bcda" would also be valid, as long as "b", "c", "a" maintain their order.

    Constraints:
    - 1 <= order.length <= 26
    - 1 <= s.length <= 200
    - order and s consist of lowercase English letters.
    - All the characters of order are unique.
*/
public class Leetcode_791 {
    public static String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();
        String str = "";
        for(int i=0; i<order.length(); i++) {
            map.put(order.charAt(i), 1);
        }
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map1.containsKey(s.charAt(i)))
                    map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
                else
                    map1.put(s.charAt(i), 1);
            }
            else {
                str += s.charAt(i);
            }
        }
        for(int i=0; i<order.length(); i++) {
            if(map1.containsKey(order.charAt(i)) && map1.get(order.charAt(i)) == 1) {
                str += order.charAt(i);
            }
            if(map1.containsKey(order.charAt(i)) && map1.get(order.charAt(i)) != 1) {
                for(int j=0; j<map1.get(order.charAt(i)); j++)
                    str += order.charAt(i);
            }
        }
        return str;
    }
    public static void main(String[] args) {
        String order = "hucw", s = "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh";
        System.out.println(customSortString(order, s));
    }
}
