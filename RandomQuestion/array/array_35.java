package RandomQuestion.array;
/*
 * 35. Search Insert Position
    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [1,3,5,6], target = 5
    Output: 2
    
    Example 2:
    Input: nums = [1,3,5,6], target = 2
    Output: 1
    
    Example 3:
    Input: nums = [1,3,5,6], target = 7
    Output: 4
    
    Constraints:
    1 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    nums contains distinct values sorted in ascending order.
    -10^4 <= target <= 10^4
*/
public class array_35 {
    public static int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        if(target<=nums[0]) return 0;
        while (i<=j) {
            int mid = (i + j)/2;
            if(nums[mid] == target)
                return mid;
            else if(target < nums[mid])
                j = mid-1;
            else 
                i = mid + 1;
        }
        if(nums.length == 1 && nums[0] == target)
            return 0;
        else if(target < nums[j])
            return j;
        return j+1;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}