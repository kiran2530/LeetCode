/*
 *  40. Combination Sum II
        Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
        Each number in candidates may only be used once in the combination.
        Note: The solution set must not contain duplicate combinations.

    Example 1:
        Input: candidates = [10,1,2,7,6,1,5], target = 8
        Output: 
        [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
        ]
        
    xample 2:
        Input: candidates = [2,5,2,1,2], target = 5
        Output: 
        [
        [1,2,2],
        [5]
        ]
        
    Constraints:
        1 <= candidates.length <= 100
        1 <= candidates[i] <= 50
        1 <= target <= 30
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _13_08_24_leetcode_40 {

  public static void solve(int[] candidates, int target, int idx, List<Integer> temp,List<List<Integer>> res, int sum) {
    if (idx > candidates.length || sum > target) {
      return;
    }
    if (sum == target) {
      res.add(new ArrayList<>(temp));
      return;
    }
    for (int j = idx; j < candidates.length; j++) {
      if (j > idx && candidates[j] == candidates[j - 1]) continue;
      temp.add(candidates[j]);
      solve(candidates, target, j + 1, temp, res, sum + candidates[j]);
      temp.remove(temp.size() - 1);
    }

    return;
  }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, new ArrayList<>(), res, 0);
        return res;
  }

  public static void main(String[] args) {
    int[] candidate = {10,1,2,7,6,1,5};
    int target = 8;

    System.out.println(combinationSum2(candidate, target));
  }
}
