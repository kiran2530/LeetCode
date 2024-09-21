/*
 *  386. Lexicographical Numbers
        Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
        You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

    Example 1:
        Input: n = 13
        Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
        
    Example 2:
        Input: n = 2
        Output: [1,2]
        

    Constraints:
        1 <= n <= 5 * 10^4
 */

import java.util.ArrayList;
import java.util.List;

public class _21_09_24_leetcode_386 {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        int current = 1;

        for (int i = 0; i < n; i++) {
            ans.add(current);
            if (current * 10 <= n) {
                current *= 10;
            } else {
                while (current % 10 == 9 || current + 1 > n) {
                    current /= 10;
                }
                current++;
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }
}