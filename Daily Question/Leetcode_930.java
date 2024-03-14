/**
 * 930. Binary Subarrays With Sum 
    Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal. A subarray is a contiguous part of the array.

    Example 1:
    Input: nums = [1,0,1,0,1], goal = 2
    Output: 4
    Explanation: The 4 subarrays are bolded and underlined below:
    [1,0,1,0,1]
    [1,0,1,0,1]
    [1,0,1,0,1]
    [1,0,1,0,1]

    Example 2:
    Input: nums = [0,0,0,0,0], goal = 0
    Output: 15

    Constraints:
    1 <= nums.length <= 3 * 10^4
    nums[i] is either 0 or 1.
    0 <= goal <= nums.length
 */
public class Leetcode_930 {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int sum = nums[i];
            if(sum == goal)
                count++;
            for(int j=i+1; j<nums.length; j++) {
                sum += nums[j];
                if(sum == goal)
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        int goal = 0;

        System.out.println(numSubarraysWithSum(nums, goal));
    }
}