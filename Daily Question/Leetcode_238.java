/*
 * 238. Product of Array Except Self
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer. You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

    Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]
    
    Constraints:
    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/
public class Leetcode_238 {
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int zero = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                zero++;
            else
                product *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if(zero > 0) {
                if(nums[i] == 0 && zero-1 == 0)
                    ans[i] = product;
                else
                    ans[i] = 0;
            }
            else
                ans[i] = product/nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] ans = productExceptSelf(nums);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
