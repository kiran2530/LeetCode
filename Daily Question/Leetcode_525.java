import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
    Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

    Example 1:
    Input: nums = [0,1]
    Output: 2
    Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

    Example 2:
    Input: nums = [0,1,0]
    Output: 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

    Constraints:
    1 <= nums.length <= 105
    nums[i] is either 0 or 1.
*/
public class Leetcode_525 {
    public static int findMaxLength(int[] nums) {
        // int zero = 0, one = 1, length = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     zero = 0;
        //     one = 0;
        //     for (int j = i; j < nums.length; j++) {
        //         if(nums[j] == 0)
        //             zero++;
        //         else
        //             one++;
        //         if(zero == one && length < (one+zero))
        //             length = one+zero;
        //     }
        // }
        // return length;

        // Using hashmap
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int subArrayLength = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                subArrayLength = i + 1;
            } else if (mp.containsKey(sum)) {
                subArrayLength = Math.max(subArrayLength, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return subArrayLength;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,1};
        System.out.println(findMaxLength(nums));
    }
}