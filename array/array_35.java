public class array_35 {
    public static int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i<j) {
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

        if(target < nums[i])
            return i;
        return i+1;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}