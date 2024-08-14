/* 
 *  719. Find K-th Smallest Pair Distance
        The distance of a pair of integers a and b is defined as the absolute difference between a and b.
        Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

    Example 1:
        Input: nums = [1,3,1], k = 1
        Output: 0
        Explanation: Here are all the pairs:
        (1,3) -> 2
        (1,1) -> 0
        (3,1) -> 2
        Then the 1st smallest distance pair is (1,1), and its distance is 0.
        
    Example 2:
        Input: nums = [1,1,1], k = 2
        Output: 0
        
    Example 3:
        Input: nums = [1,6,1], k = 3
        Output: 5
        
    Constraints:
        n == nums.length
        2 <= n <= 10^4
        0 <= nums[i] <= 10^6
        1 <= k <= n * (n - 1) / 2
*/

import java.util.Arrays;

public class _14_08_24_leetcode_719 {
    public static int smallestDistancePair(int[] nums, int k) {
        // int n = nums.length, idx = 0;
        // int[] arr = new int[((n-1)*n)/2];

        // for (int i = 0; i < n-1; i++) {
        //     for (int j = i+1; j < n; j++) {
        //         int distance = Math.abs((nums[i] - nums[j]));
        //         arr[idx++] = distance;
        //     }
        // }

        // Arrays.sort(arr);
        // return arr[k-1];

        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int left = 0;
            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {1,6,1};
        int k = 3;

        System.out.println(smallestDistancePair(nums, k));
    }
}
