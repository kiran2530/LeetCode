/*
 *  241. Different Ways to Add Parentheses
        Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
        The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

    Example 1:
        Input: expression = "2-1-1"
        Output: [0,2]
        Explanation:
        ((2-1)-1) = 0 
        (2-(1-1)) = 2
        
    Example 2:
        Input: expression = "2*3-4*5"
        Output: [-34,-14,-10,-10,10]
        Explanation:
        (2*(3-(4*5))) = -34 
        ((2*3)-(4*5)) = -14 
        ((2*(3-4))*5) = -10 
        (2*((3-4)*5)) = -10 
        (((2*3)-4)*5) = 10
        
    Constraints:
        1 <= expression.length <= 20
        expression consists of digits and the operator '+', '-', and '*'.
        All the integer values in the input expression are in the range [0, 99].
        The integer values in the input expression do not have a leading '-' or '+' denoting the sign.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _19_09_24_leetcode_241 {
    static HashMap<String, List<Integer>> m = new HashMap<>();
    
    public static List<Integer> solveTopDown(String s) {
        if (m.containsKey(s)) return m.get(s);
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = solveTopDown(s.substring(0, i));
                List<Integer> right = solveTopDown(s.substring(i + 1));
                
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') ans.add(l + r);
                        else if (c == '-') ans.add(l - r);
                        else ans.add(l * r);
                    }
                }
            }
        }
        if (ans.isEmpty()) ans.add(Integer.parseInt(s));
        m.put(s, ans);
        return ans;
    }
    
    public static List<Integer> diffWaysToCompute(String expression) {
        return solveTopDown(expression);
    }

    public static void main(String[] args) {
        String s = "2*3-4*5";
        System.out.println(diffWaysToCompute(s));
    }
}
